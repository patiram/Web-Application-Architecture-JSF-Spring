<%@ page isErrorPage="true" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="errorMessage"><%= exception.getLocalizedMessage() %></div>
<pre class="errorStackTrace">
<%
	java.io.CharArrayWriter cw = new java.io.CharArrayWriter();
	java.io.PrintWriter pw = new java.io.PrintWriter(cw, true);
	exception.printStackTrace(pw);
	out.println(cw.toString());
%>
</pre>
</body>
</html>