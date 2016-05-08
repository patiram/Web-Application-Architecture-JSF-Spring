<%-- 
    Document   : login
    Created on : Apr 25, 2016, 8:27:30 PM
    Author     : PatiRam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
        <title>login</title>
    </head>
    <body>
        <div class="container">
            <form action="FormServlet" method="POST">
                <table>
                    <tr>
                        <td><input type="text" name="name" id="name" value="${user.name}" placeholder="User Name" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="number" name="age" id="age" value="${user.age}" placeholder="Age" class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="password" name="password" id="password" placeholder="Password" class="form-control"/></td>
                    </tr>
       
                    <tr>
                        <td>
                            <br/>
                            <input type="submit" value="Login" class="form-control"/>
                        </td>
                    </tr>
                </table>
                            <h3>Login attemts! ${sessionScope.noOfAttempts}</h3>
            </form>
        </div>
    </body>
</html>
