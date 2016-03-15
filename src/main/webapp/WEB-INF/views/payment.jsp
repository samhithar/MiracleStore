<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--checkout_Banner -->
<!-- spring form tag prefix : form -->
<!-- spring tag prefix : stag -->

<div class="single_top">
	 <div class="container"> 
	  	   <div class="col-md-9 contact_left">
	  	   <div class="message">
            <%-- <c:if test="${message!=null}">${message}</c:if> --%>
            <c:if test="${not empty message}"><font color="red"><c:out value="${message}" /></font>
</c:if>
        </div>
	  	   <form:form method="post" commandName="payment">
		 <div class="col-md-3 contact_right">
		 	<h2>Price Details</h2>
		 	<!-- <address class="address"> -->
		 	
		 	<div class="column_8">
					
	               
				   <form:input 
				   		
						class="text" 
						type="text"
						path="productPrice"
						placeholder = "MSRP"
						name="productPrice"
						id="productPrice"
						readonly="true"
						/>
				   
		</div>
		 	  
         <div class="column_8">
					
	               
				   <form:input 
				   		
						class="text" 
						type="text"
						path="tax"
						name="tax"
						placeholder = "tax"
						id="tax"
						readonly="true"/>
				   
		</div>
		<div class="column_8">
					
	               
				   <form:input 
				   		
						class="text" 
						type="text"
						path="amount"
						name="amount"
						placeholder="Total Amount"
						id="amount"
						readonly="true"/>
				   
		</div>
           <!-- </address> -->
		 </div>
</form:form>
	  	   <div class="col-md-9 contact_left">
		 	  <h1>Payment</h1>
		 	  
			  
	  			   <form:form role="form" id="payment-form" action="paymentController" commandName="payment" method="post">
		<div class="column_3">
					
	               
				   <input 
				   		
						class="text" 
						type="text"
						path="cardNumber"
						placeholder="Valid Card Number"
						name="cardNumber"
						id="cardNumber"
						pattern="^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$" 
				   		maxlength="16" 
				   		autofocus 
				   		required/>
				   
		</div>
		<div class="clearfix"> </div>  
		<div class="column_2">
                     
                    <input 
                    class="text" type="text"
						path="expDate"
						placeholder="Exp Date"
						id="expDate"
						name="expDate"
						required
						maxlength="4"  
						pattern="(0[1-9]|1[0-2])[0-9]{2}" 
                     	autofocus 
                     	required />
					 <input 
					 	class="text" type="text"
						path="cvv"
						placeholder="CVV"
						id="cvv"
						name="cvv"
						maxlength="4"
						autocomplete="cc-csc"
						required
					 	pattern="^[0-9]{3,4}$" 
					 	autofocus 
					 	 />
					
		</div>
		<div class="column_3">
					<input 
						class="text" type="text"
						maxlength="20" 
						id ="cardHolderName" 
						name="cardHolderName" 
						placeholder="Name" 
						path="cardHolderName" 
						autofocus 
						required/>
					
	     </div>
						
	     <div class="form-submit1">
			          
			        <input 
			          	type="submit" 
			          	value="Submit Payment">
		 </div>
		 
		 <div class="clearfix"> </div>
				  
				  </form:form>
		
      </div>
</div>      

<%@ include file="footer.jsp" %>