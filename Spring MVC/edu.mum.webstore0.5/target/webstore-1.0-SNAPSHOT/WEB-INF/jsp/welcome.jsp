<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
  </head>

  <body>
  <section>
    <div class="jumbotron">
      <div class="container">
        <h1> ${greeting}!</h1>
        <h2> ${user.userId}</h2>
<!--        <p> ${tagline} </p>-->
        <p> ${taglines} </p>
        <p><a href="${pageContext.request.contextPath}/logout" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </a></p>
      </div>
    </div>
  </section>
</body>
</html>
