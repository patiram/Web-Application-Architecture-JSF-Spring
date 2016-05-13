/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PatiRam
 */
public class FormServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            int totalAttempts = 0;
            HttpSession session = request.getSession(true);
             if (session.getAttribute("noOfAttempts") == null) {
                session.setAttribute("noOfAttempts", totalAttempts);
            }
            
            String username = request.getParameter("name");
            String password = request.getParameter("password");
            System.out.println(username);
            System.out.println(password);
            int age=0;
            try{
            age = Integer.parseInt(request.getParameter("age"));
            }catch(Exception e){
                System.out.println(e);
            }
            boolean isAgeOk = false;
            if(age<=10 && age>=110){
                isAgeOk = false;
            }else{
                isAgeOk = true;
            }
            User user = new User();
            user.setName("patiram");
            user.setPassword("abc");
            boolean userPassword = false;
            if(user.getName().equals(username)&&user.getPassword().equals(password)){
                userPassword = true;
            }else{
                totalAttempts = (int) session.getAttribute("noOfAttempts");
                totalAttempts++;
                session.setAttribute("noOfAttempts", totalAttempts);
                if(totalAttempts>=3){
                    session.invalidate();
                    response.sendRedirect("accessDenied.jsp");
                }
            }
            if(userPassword && isAgeOk){
                response.sendRedirect("welcome.jsp");
            }else{
                response.sendRedirect("login.jsp");
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
