<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="addToCart">
						Quantity : <input type="text" name = "prodquant"   value="1" />
						<input type="hidden" name="id" value="${products.id}" >
						<input type="submit" value="Add to cart"/>
						</form>
</body>
</html>