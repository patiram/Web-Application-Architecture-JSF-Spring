/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author PatiRam
 */
@Named("user")
@SessionScoped
public class JSFIntroDemo implements Serializable {

    private boolean bError = false;
    private String name;
    private String password;
    private int age;
    private static int numOfAttempts = 0;

    // value="#{user.name}"
    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    // value="#{user.password}"
    public String getPassword() {
        return password;
    }

    public void setPassword(String newValue) {
        password = newValue;
    }

    // rendered="#{user.error}"
    public boolean isError() {
        return bError;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public int getNumOfAttempts() {
        return numOfAttempts;
    }

    // action="#{user.onLogin}"
    // As we shall see, the return value indicates what the next page will be
    public String onLogin() {
        bError = (!password.equals("abc")) || (!name.equals("patiram"));
        System.out.println(bError);
        if (bError) {
            numOfAttempts++;
            if (numOfAttempts >= 3) {
                return "locked";
            } else {
                return "login";  // redisplay login.xhtml so that user can reenter the password
            }
        } else {
            return "welcome";  // display welcome.xhtml
        }
    }
}
