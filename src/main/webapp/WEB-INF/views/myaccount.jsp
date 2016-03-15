<%@ include file="myaccount_header.jsp" %>		

		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="forms">
			<div class="form-three widget-shadow">
							<form:form class="form-horizontal" action="updateProfileProcess" method="post" commandName="customer">
							<div class="form-group">
									<label class="col-md-2 control-label">User Name: </label>
									<div class="col-sm-8">
										<form:input type="text" class="form-control1" path="customerId" value="${customerDetails.customerId}" onkeydown="event.preventDefault()" readonly="readonly"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">First Name: </label>
									<div class="col-sm-8">
										
									    <form:input type="text" class="form-control1" id="focusedinput" path="firstname" value="${customerDetails.firstname}" onkeydown="event.preventDefault()" readonly="readonly"/>
									</div>
									
								</div>
								 <div class="form-group">
									<label class="col-md-2 control-label">Last Name: </label>
									<div class="col-sm-8">
										<form:input type="text" class="form-control1 input-sm" path="lastname" value="${customerDetails.lastname}" onkeydown="event.preventDefault()" readonly="readonly"/>
									</div>
								</div>
								<div class="form-group">
								<label class="col-md-2 control-label">Email: </label>
									
									<div class="col-sm-8">
										<form:input type="text" class="form-control1" path="email" value="${customerDetails.email}" />
										<p><font color="red"><form:errors path="email"/></font></p>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label">Password: </label>
									<div class="col-sm-8">
										<form:input type="password" class="form-control1" path="password" value="${customerDetails.password}"  />
										<p><font color="red"><form:errors path="password"/></font></p>
									</div>
								</div>
								
									<div class="form-group">
									<label class="col-md-2 control-label"></label>
									<div class="col-sm-8">
									<input type="submit" value = "Update" class="btn btn-default">
								    </div>
									</div>
								
								
							</form:form>
						</div>
					
					</div>
					</div>
					</div>
		<!--footer-->
<%@ include file="myaccount_footer.jsp" %>