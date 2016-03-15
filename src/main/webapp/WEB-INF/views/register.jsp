<%@ include file="/index_header.jsp" %>

<!--checkout_Banner -->
<!-- spring form tag prefix : form -->
<!-- spring tag prefix : stag -->


<div class="single_top">
<div class="container"> 
	     <div class="register">
		  	   
			  <form:form action="registerProcess" method="post" commandName="customer">
			  <div class="register-top-grid">
					<h3>PERSONAL INFORMATION</h3>
					
					 <div>
						<span>User Name<label>*</label></span>
						<form:input path="customerId" type="text"/> 
						<span ><font color="red"><form:errors path="customerId"/></font></span>
						<span>Email Id<label>*</label></span>
						<form:input path="email" type="text"/>
						<span ><font color="red"><form:errors path="email"/></font></span>
						<span>First Name<label>*</label></span>
						<form:input path="firstname" type="text"/>
						<span ><font color="red"><form:errors path="firstname"/></font></span>
						<span>Last Name<label>*</label></span>
						 <form:input path="lastname" type="text"/>  
						 <a ><font color="red"><form:errors path="lastname"/></font></a>
					 </div>
					
					
					 <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						
					   </a>
			  </div>
					 <div class="register-bottom-grid">
							 <div>
								<span>Password<label>*</label></span>
								<form:input path="password" type="password"/>
								<span ><font color="red"><form:errors path="password"/></font></span>
						
								<span>Confirm Password<label>*</label></span>
								<form:input path="confirmPassword" type="password"/>
								<span ><font color="red"><form:errors path="confirmPassword"/></font></span>
							 </div>
							
							 <div class="clearfix"> </div>
					 </div>
					 <div class="clearfix"> </div>
				<div class="register-but"></div>
				  
					   <input type="submit" value="Register"/> 
					   <div class="clearfix"> </div>
				   </form:form>
				</div>
		 </div>
</div>



<%@ include file="footer.jsp" %>