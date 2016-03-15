<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2 align="center">My Profile</h2>
			
			<s:form action="updateProfileProcess" method="post" commandName="customer">
			
				<table>
					<tr><td>Username</td><td><s:input path="customerId" value="${customerDetails.customerId}" onkeydown="event.preventDefault()" readonly="readonly"/></td></tr>
					<tr><td>FirstName</td><td><s:input path="firstname" value="${customerDetails.firstname}"/></td><td><font color="red"><s:errors path="firstname"/></font></td></tr>
					<tr><td>LastName</td><td><s:input path="lastname" value="${customerDetails.lastname}"/></td><td><font color="red"><s:errors path="lastname"/></font></td></tr>
					<tr><td>Email</td><td><s:input path="email" value="${customerDetails.email}"/></td><td><font color="red"><s:errors path="email"/></font></td></tr>
					<tr><td>Password</td><td><s:input type="password" path="password" value="${customerDetails.password}"/></td><td><font color="red"><s:errors path="password"/></font></td></tr>					
					<tr><td><input type="submit" value="UPDATE"/></td></tr>
				</table>
			
			</s:form>
			
</body>
</html>