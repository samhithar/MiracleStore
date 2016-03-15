<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <form:form action="shippingBillingController" method="post" commandName="ids">
			
				<table>
					<tr><td>Shipping Address</td><td><form:select items="${shippingAddressLine1List}" path="shippingID.addressLine1"></form:select></td></tr>
					<tr><td>Billing Address</td><td><form:select items="${shippingAddressLine1List}" path="billingId.addressLine1"></form:select></td></tr>
					<tr><td><input type="submit" value="NEXT"/></td></tr>
				</table>
			
			</form:form>

</body>
</html>