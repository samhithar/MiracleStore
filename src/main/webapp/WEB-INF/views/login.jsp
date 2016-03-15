<%-- <%@ page import = "org.springframework.security.core.context.SecurityContextHolder" %>

<%if(SecurityContextHolder.getContext().getAuthentication().getName()!=null){ %>
<%@ include file="/index_header.jsp" %>
<%}
else{
%>
<%@ include file="header.jsp" %>
<%} %>
 --%>
 
<%@ include file="/index_header.jsp" %>

<!--checkout_Banner -->
<!-- spring form tag prefix : form -->
<!-- spring tag prefix : stag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="single_top">
	 <div class="container"> 
	    <div class="register">
			  <div class="col-md-6 login-right">
			  	<h3>REGISTERED CUSTOMERS</h3>
				<p>If you have an account with us, please log in.</p>
				<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		<font color="red"> Your login attempt was not successful due to : 
			
		 <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
		</font>
	</c:if>
				<form:form action="j_spring_security_check" method="post" commandName="customer">
				  <div>
					<span>Customer Id<label>*</label></span>
					
                    <input type="text" name="j_username" required="true"/> 					
				  </div>
				  <div>
					<span>Password<label>*</label></span>
					
					<input type="password" name="j_password" required="true"/>
				  </div>
				  <input type="submit" value="Login">
			    </form:form>
			   </div>
			    
			   <div class="clearfix"> </div>
		</div>
     </div>
</div>   


<%@ include file="footer.jsp" %>