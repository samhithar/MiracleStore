<%-- <%@ page import = "org.springframework.security.core.context.SecurityContextHolder" %>

<%if(SecurityContextHolder.getContext().getAuthentication().getName()!=null){ %>
<%@ include file="index_header.jsp" %>
<%}
else{
%>
<%@ include file="WEB-INF/views/header.jsp" %>
<%} %> --%>

<%@ include file="index_header.jsp" %>

<!--checkout_Banner -->
<!-- spring form tag prefix : form -->
<!-- spring tag prefix : stag -->

<!--Middle_Banner-->
<div class="banner">
	<div class="container">
		<div class="banner_desc">
			<h1>New Season Arrivals.</h1>
			<h2>Check out all the new trends</h2>
			<div class="button">
			      <a href="#" class="hvr-shutter-out-horizontal">Shop Now</a>
			    </div>
		</div>
	</div>
</div>

<%@ include file="WEB-INF/views/footer.jsp" %>