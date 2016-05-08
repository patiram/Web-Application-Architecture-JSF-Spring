<%-- 
    Document   : login
    Created on : Apr 25, 2016, 2:20:00 PM
    Author     : Pati Ram
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
            <form action="LoginServlet" method="POST">
                <table>
                    <tr>
                        <td>
                            <c:if test="${requestScope.error}">
                                <div class="alert alert-danger">${messages.loginMessage}</div>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="uername" id="username" value="${user.username}" placeholder="User Name" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="number" name="age" id="age" value="${user.age}" placeholder="Age" class="form-control"/>
                        </td>
                        <td>
                            <span>
                                <c:if test="${requestScope.invalidAge}">
                                    <div class="alert alert-danger">${messages.invalidAgeMessage}</div>
                                </c:if>
                            </span>
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
            </form>
        </div>
    </body>
</html>
