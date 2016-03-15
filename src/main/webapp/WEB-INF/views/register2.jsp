<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<h2 align="center">Register Form</h2>
			
			<s:form action="registerProcess" method="post" commandName="customer">
			
				<table>
					<tr><td>Username *</td><td><s:input path="customerId"/></td><td><font color="red"><s:errors path="customerId"/></font></td></tr>
					<tr><td>FirstName *</td><td><s:input path="firstname"/></td><td><font color="red"><s:errors path="firstname"/></font></td></tr>
					<tr><td>LastName *</td><td><s:input path="lastname"/></td><td><font color="red"><s:errors path="lastname"/></font></td></tr>
					<tr><td>Email *</td><td><s:input path="email"/></td><td><font color="red"><s:errors path="email"/></font></td></tr>
					<tr><td>Password *</td><td><s:input type="password" path="password"/></td><td><font color="red"><s:errors path="password"/></font></td></tr>					
					<tr><td>confirmPassword *</td><td><s:input type="password" path="confirmPassword"/></td><td><font color="red"><s:errors path="confirmPassword"/></font></td></tr>
					
				</table>
				<br>
				<br>
				Note: Fields marked with * are mandatory fields<br>
				<input type="submit" value="REGISTER"/>
			</s:form>

</body>
</html>