<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ page errorPage="errorpage.jsp" %>  
<f:view>  
<f:loadBundle basename="com.j3ltd.web.messages.ApplicationMessages" var="msg"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><h:outputText value="#{msg.pageTitle}"/></title>
<link href="styles.css" rel="stylesheet" type="text/css">
</head>
<body> 

<h:form id="registerForm">
<div class="pageTitle"><h:outputText value="#{msg.registration}"/></div>
<br/>
<div class="center">
<h:panelGrid columns="2"  
	styleClass="form" 
	headerClass="tableHeader"
	footerClass="tableFooter"
	rowClasses="tableRowOdd, tableRowEven">
	<f:facet name="header">
		<h:outputFormat value="#{msg.registrationBoxTitle}">
			<f:param value="*"/>
		</h:outputFormat>
	</f:facet>
	
	<f:facet name="footer">
		<h:panelGroup>
		<h:commandButton value="#{msg.submit}" 
	  	action="#{registrationBean.register}" />
		<h:commandButton value="#{msg.reset}" type="reset"/>
		</h:panelGroup>
	</f:facet>
		
	<h:outputLabel for="title" value="#{msg.registrationTitle}"/>
	<h:panelGroup>
	<h:inputText id="title" value="#{registrationBean.person.title}"
		maxlength="45" size="10"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="title" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="firstName" value="#{msg.registrationName}"/>
	<h:panelGroup>
	<h:inputText id="firstName" value="#{registrationBean.person.firstName}"
		maxlength="255" size="30"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="firstName" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="lastName" value="#{msg.registrationSurname}"/>
	<h:panelGroup>
	<h:inputText id="lastName" value="#{registrationBean.person.lastName}"
		maxlength="255" size="30"/><f:verbatim><br/></f:verbatim>
  <h:outputText value=" "/><h:message for="lastName" styleClass="formUserError"/>
  </h:panelGroup>
  
	<h:outputLabel for="suffix" value="#{msg.registrationSuffix}"/>
	<h:panelGroup>
	<h:inputText id="suffix" value="#{registrationBean.person.suffix}"
		maxlength="45" size="15"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="suffix" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="dateOfBirth" value="#{msg.registrationDateOfBirth}"/>
	<h:panelGroup>
	<h:inputText id="dateOfBirth" value="#{registrationBean.person.dateOfBirth}">
		<f:convertDateTime pattern="dd/MM/yyyy"/>
	</h:inputText>	<f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="dateOfBirth" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="gender" value="#{msg.registrationGender}"/>
	<h:selectOneRadio id="gender" value="#{registrationBean.person.gender}">	
		<f:selectItems value="#{registrationBean.genders}"/>	
	</h:selectOneRadio>
	
	<h:outputLabel for="maritalStatus" value="#{msg.registrationMaritalStatus}"/>
	<h:selectOneRadio id="maritalStatus" value="#{registrationBean.person.maritalStatus}">	
		<f:selectItems value="#{registrationBean.maritalStati}"/>	
	</h:selectOneRadio>
	
	<h:outputLabel for="line1" value="#{msg.registrationAddress1}"/>
	<h:panelGroup>
	<h:inputText id="line1" value="#{registrationBean.person.address.line1}"
		maxlength="255" size="50"/>	<f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="line1" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="line2" value="#{msg.registrationAddress2}"/>
	<h:panelGroup>
	<h:inputText id="line2" value="#{registrationBean.person.address.line2}"
		maxlength="255" size="50"/>	<f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="line2" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="line3" value="#{msg.registrationAddress3}"/>
	<h:panelGroup>
	<h:inputText id="line3" value="#{registrationBean.person.address.line3}"
		maxlength="255" size="50"/>	<f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="line3" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="line4" value="#{msg.registrationAddress4}"/>
	<h:panelGroup>
	<h:inputText id="line4" value="#{registrationBean.person.address.line4}"
		maxlength="255" size="50"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="line4" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="postcode" value="#{msg.registrationPostcode}"/>
	<h:panelGroup>
	<h:inputText id="postcode" value="#{registrationBean.person.address.postcode}"
		maxlength="50" size="20"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="postcode" styleClass="formUserError"/>	
	</h:panelGroup>
	
	<h:outputLabel for="country" value="#{msg.registrationCountry}"/>
	<h:panelGroup>
	<h:inputText id="country" value="#{registrationBean.person.address.country}"
		maxlength="150" size="40"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="country" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="daytimePhone" value="#{msg.registrationPhoneDay}"/>
	<h:panelGroup>
	<h:inputText id="daytimePhone" value="#{registrationBean.person.daytimePhone}"
		maxlength="45" size="12"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="daytimePhone" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="eveningPhone" value="#{msg.registrationPhoneEvening}"/>
	<h:panelGroup>
	<h:inputText id="eveningPhone" value="#{registrationBean.person.eveningPhone}"
		maxlength="45" size="12"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="eveningPhone" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="email" value="*#{msg.registrationEmail}"/>
	<h:panelGroup>
	<h:inputText id="email" value="#{registrationBean.person.email}" 
		maxlength="255" size="50" 
		required="true">
			<f:validator validatorId="EmailValidator"/>
	</h:inputText><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="email" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="emailConfirm" value="*#{msg.registrationEmailConfirm}"/>
	<h:panelGroup>
	<h:inputText id="emailConfirm" value="#{registrationBean.emailConfirm}" 
		maxlength="255" size="50" 
		required="true"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="emailConfirm" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="password" value="*#{msg.registrationPassword}"/>
	<h:panelGroup>
	<h:inputSecret id="password" value="#{registrationBean.person.password}" 
		maxlength="64" size="20" 
		required="true" redisplay="true">
			<f:validateLength minimum="6"/>
	</h:inputSecret><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="password" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="passwordConfirm" value="*#{msg.registrationPasswordConfirm}"/>
	<h:panelGroup>
	<h:inputSecret id="passwordConfirm" value="#{registrationBean.passwordConfirm}" 
		maxlength="64" size="20" 
		required="true" redisplay="true"/><f:verbatim><br/></f:verbatim>
	<h:outputText value=" "/><h:message for="passwordConfirm" styleClass="formUserError"/>
	</h:panelGroup>
	
	<h:outputLabel for="webSite" value="#{msg.registrationWeb}"/>
	<h:panelGroup>
	<h:inputText id="webSite" value="#{registrationBean.person.webSite}"
		maxlength="255" size="50"/><f:verbatim><br/></f:verbatim>
		<h:outputText value=" "/><h:message for="webSite" styleClass="formUserError"/>
	</h:panelGroup>
		
</h:panelGrid>
</div>
</h:form>
</body>
</html>
</f:view>