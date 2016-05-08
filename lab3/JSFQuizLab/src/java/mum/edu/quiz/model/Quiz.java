/*
 * Quiz has a set of questions that can be presented to a person.
 * it also tracks the number of correct responses.
 * also tracks where in the quiz the person is at.
 */
package mum.edu.quiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author levi
 */
@Named
@SessionScoped
public class Quiz implements Serializable {

    private ArrayList<Problem> questions = new ArrayList<Problem>();
    private ArrayList<String> answers;
    private int numCorrect = 0;
    /* 0 based index for the current question */
    private int currentProblemIndex = 0;
    private int numQuestions;
    private Problem currentProblem = null;
    private String hintVisibility = "hidden";
    private String txtAnswer;
    private String errorVisibility = "hidden";
    private int attempts = 0;

    private int score = 0;

    private String errorAns;

    private String grade;

    /**
     *
     */
    public int getNumQuestions() {
        return questions.size();
    }

    /**
     * Create a new Quiz with questions
     */
    public Quiz() {
        questions.add(new Problem("[3 1 4 1 5]", "9", "pi"));
        questions.add(new Problem("[1 1 2 3 5]", "8", "fibonacci"));
        questions.add(new Problem("[1, 4, 9, 16, 25]", "36", "squares"));
        questions.add(new Problem("[2, 3, 5, 7, 11]", "13", "primes"));
        questions.add(new Problem("[1 2 4 8 16]", "32", "2 powers"));
        numQuestions = getNumQuestions();
        currentProblem = questions.get(0);
    }

    /**
     * return true or false if answer is correct or false for current question
     *
     * @param ans
     * @return
     */
    public boolean isCorrect(String ans) {
        System.out.println(ans);
        if (ans.equals(questions.get(currentProblemIndex).getAnswer())) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * increment the currentQuestion index and also increment the score (should
     * be called if answer is correct.
     */
    public void scoreAnswer() { //String ans) {
        currentProblemIndex++;
        numCorrect++;
        if (currentProblemIndex < numQuestions) {
            setCurrentProblem(questions.get(currentProblemIndex));
        }
    }

    /**
     * getter
     *
     * @return
     */
    public int getNumCorrect() {
        return this.numCorrect;
    }

    /**
     * getter
     */
    public int getCurrentQuestionIndex() {
        return this.currentProblemIndex;
    }

    /**
     * return the text for the current question
     */
    public Problem getCurrentProblem() {
        return currentProblem;
    }

    private void setCurrentProblem(Problem currentProblem) {
        this.currentProblem = currentProblem;
    }

    public String getHintVisibility() {
        return hintVisibility;
    }

    public void setHintVisibility(String hintVisibility) {
        this.hintVisibility = hintVisibility;
    }

    public String getErrorVisibility() {
        return errorVisibility;
    }

    public void setErrorVisibility(String errorVisibility) {
        this.errorVisibility = errorVisibility;
    }

    public String getTxtAnswer() {
        return txtAnswer;
    }

    public void setTxtAnswer(String txtAnswer) {
        this.txtAnswer = txtAnswer;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getErrorAns() {
        return errorAns;
    }

    public void setErrorAns(String errorAns) {
        this.errorAns = errorAns;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void onHint() {
        hintVisibility = "visible";
    }

    public String onNext() {
        if (txtAnswer != null && isCorrect(txtAnswer)) {
            errorVisibility = "hidden";
            hintVisibility = "hidden";
            switch (attempts) {
                case 0:
                    score = score + 10;
                    break;
                case 1:
                    score = score + 5;
                    break;
                default:
                    score = score + 2;
                    break;
            }
            scoreAnswer();
            attempts = 0;
            errorAns = "";
            txtAnswer = "";
            if (getNumQuestions() == getCurrentQuestionIndex()) {
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                if (score >= 45) {
                    grade = "A";
                } else if (score >= 35) {
                    grade = "B";
                } else if (score >= 25) {
                    grade = "C";
                } else {
                    grade = "NC";
                }
                score = 0;
                return "gameover";
            }
        } else {
            errorVisibility = "visible";
            attempts++;
            txtAnswer = "";
            if (attempts == 3) {
                errorAns = "Answer of previous question is: " + questions.get(currentProblemIndex).getAnswer();
                attempts = 0;
                txtAnswer = "";
                //currentProblemIndex++;
                numCorrect--;
                scoreAnswer();
            }
        }
        return "";
    }

    public String escape() {
        numCorrect--;
        scoreAnswer();
        if (currentProblemIndex < numQuestions) {
            return null;
        } else if (getNumQuestions() == getCurrentQuestionIndex()) {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            if (score >= 45) {
                grade = "A";
            } else if (score >= 35) {
                grade = "B";
            } else if (score >= 25) {
                grade = "C";
            } else {
                grade = "NC";
            }
            score = 0;

            return "gameover";
        } else {
            return "gameover";
        }

    }

    public String onReset() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return null;
    }

}
