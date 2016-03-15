<!DOCTYPE HTML>
<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib  uri="http://www.springframework.org/tags" prefix="stag"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<stag:url value="/resources/js/countries.js" var="countriesJs" />
<script src="${countriesJs}"></script>


</head>
<body>

			<h2 align="center">Add Address</h2>
			
			<s:form action="addressProcess" method="post" commandName="address">
			
				<table>
					<tr><td>AddressLine1</td><td><s:input path="addressLine1"/></td><td><font color="red"><s:errors path="addressLine1"/></font></td></tr>
					<tr><td>AddressLine2</td><td><s:input path="addressLine2"/></td></tr>
					
					<tr><td>Country</td><td><s:select id="country" path="country" ><option>${address.country}</option></s:select></td><td><font color="red"><s:errors path="country"/></font></td></tr>
					<tr><td>State</td><td><s:select path="state" id ="state"><option>${address.state}</option></s:select></td><td><font color="red"><s:errors path="state"/></font></td></tr>
					<tr><td>City</td><td><s:input path="city"/></td><td><font color="red"><s:errors path="city"/></font></td></tr>

					
					<tr><td>Zipcode</td><td><s:input path="zipcode"/></td><td><font color="red"><s:errors path="zipcode"/></font></td></tr>					
					<tr><td><input type="submit" value="ADD"/></td></tr>
				</table>
			
			</s:form>
<script>

populateCountries("country", "state");	
populateStates("country", "state");	

</script>

</body>
</html>