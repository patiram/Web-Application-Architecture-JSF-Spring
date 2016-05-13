/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.servlet;

import mum.edu.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pati Ram
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int totalAttempts = 0;
            HttpSession session = request.getSession(true);

            if (session.getAttribute("noOfAttempts") == null) {
                session.setAttribute("noOfAttempts", totalAttempts);
            }

            Map<String, String> messages = new HashMap<>();
            request.setAttribute("messages", messages);

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            boolean valideAge = true;
            int age;
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            try {
                age = Integer.parseInt(request.getParameter("age"));
                user.setAge(age);
                if (!(age >= 12 && age <= 125)) {
                    valideAge = false;
                    request.setAttribute("invalidAge", true);
                    messages.put("invalidAgeMessage", "Age should be between 12 - 125");
                }
            } catch (Exception e) {
                valideAge = false;
                request.setAttribute("invalidAge", true);
                messages.put("invalidAgeMessage", "Please enter age.");
            }

            boolean isSuccess = false;
            if((user.getName().equals("patiram")) && (user.getPassword().equals("abc"))){
                isSuccess = true;
            }
            if (valideAge) {
                if (isSuccess) {
                    user.setNoOfAttempts(0);
                    session.setAttribute("attempts", user.getNoOfAttempts());
                    request.setAttribute("user", user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
                    dispatcher.forward(request, response);
                } else {
                    totalAttempts = (int) session.getAttribute("attempts");
                    totalAttempts++;
                    if (totalAttempts == 3) {
                        session.invalidate();
                        RequestDispatcher maxAttemptsDispatcher = request.getRequestDispatcher("exceeds.jsp");
                        maxAttemptsDispatcher.forward(request, response);
                    } else {
                        user.setNoOfAttempts(totalAttempts);
                        session.setAttribute("attempts", user.getNoOfAttempts());
                        request.setAttribute("error", true);
                        messages.put("loginMessage", "Invalid Username or Password");
                        request.setAttribute("user", user);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                        dispatcher.forward(request, response);
                    }
                }
            } else {
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
