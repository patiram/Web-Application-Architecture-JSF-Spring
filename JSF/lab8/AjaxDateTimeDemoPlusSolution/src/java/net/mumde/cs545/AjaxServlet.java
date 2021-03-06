package net.mumde.cs545;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.urlPatternType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AjaxServlet", urlPatterns = {"*.ajax"})
public class AjaxServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Two ways to determine whether to handle date or temperature
     * String s;
     * 1.Look at the servlet path (e.g., date.ajax return date, temp.ajax return temperature
     *   s = request.getServletPath();
     * 2. Use getParameter by setting parameters in xhr.open
     *   Can add name/value pairs to the url argument of xhr.open
     *   xhr.open("POST", url+"?"+params, …  
         */

        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setStatus(HttpServletResponse.SC_OK);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log(e.toString());
        }
        if (request.getServletPath().contains("/dateAndTime.ajax")) {
            response.getWriter().write("FromServlet: " + ((new java.util.Date()).toString()));
        } else if (request.getServletPath().contains("/temperature.ajax")) {
            response.getWriter().write("FromServlet: Temperature is 60F");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
