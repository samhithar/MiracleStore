<%@ include file="myaccount_header.jsp" %>

<div id="page-wrapper">
			<div class="main-page">
				<h3 class="title1">Delete Account</h3>
				<div class="blank-page widget-shadow scroll" id="style-2 div1">
					<p> If you delete your account, you cannot restore it in the future.
					</p>
				</div>
			</div>
			
		    <div class="form-group">
				<form:form action="deleteProfileProcess" method="post">
				<div class="col-sm-8">
				<input type="submit" value="Delete Account">
				</div>
				</form:form>
			</div>
</div>

<%@ include file="myaccount_footer.jsp" %>