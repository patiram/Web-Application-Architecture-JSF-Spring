
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ page errorPage="errorpage.jsp" %>  
<f:view>  
<f:loadBundle basename="com.j3ltd.web.messages.ApplicationMessages" var="msg"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><h:outputText value="#{msg.pageTitle}"/></title>
<link href="styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<h:form >
<div class="pageTitle"><h:outputText value="#{msg.welcome}"/></div>
<br/>
<div class="center">
<h:panelGrid columns="3" 
  styleClass="form"
	headerClass="tableHeader">
	<f:facet name="header">
		<h:outputText value="#{msg.welcomeBoxTitle}"/>
	</f:facet>
		<h:outputText value="#{msg.login}"/>
		
		<h:commandLink action="register" id="register">
			<h:outputText value="#{msg.register}"/>
		</h:commandLink>
		
		<h:outputText value="#{msg.forgotPassword}"/>
		
		<h:outputText value=" "/><h:outputText value=" "/><h:outputText value=" "/>
		
		<h:commandLink id="english" action="chooseLocale"
       actionListener="#{welcomeBean.onChooseLocale}">
    	<h:outputText value="#{msg.english}" />
    </h:commandLink>
	  <h:outputText value=" "/>
		<h:commandLink id="french" action="chooseLocale"
       actionListener="#{welcomeBean.onChooseLocale}">
    	<h:outputText value="#{msg.french}" />
    </h:commandLink>
</h:panelGrid>
</div>
</h:form>
</body>
</html>
</f:view>