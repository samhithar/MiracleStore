<%@ include file="header.jsp" %>

<!--checkout_Banner -->
<!-- spring form tag prefix : form -->
<!-- spring tag prefix : stag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="single_top">
	 <div class="container"> 
	  <div class="error-404 text-center">
			
			<p>Congratulations! your order has been confirmed.</p>
			<br/>
			<p>Shipping Address :</p>
			<p>${customerName}</p>
			<p>${orderConfirmation.addressLine1}, ${orderConfirmation.addressLine2}</p>
			<p>${orderConfirmation.city}, ${orderConfirmation.state}, ${orderConfirmation.zipcode}</p><br/>
			<p>${orderConfirmation.totalAmount}, was charged on ${orderConfirmation.cardNumber}</p>
     		<a class="b-home" href="/web/Products">Back to Home</a>
		  </div>
      </div>
</div>

<%@ include file="footer.jsp" %>