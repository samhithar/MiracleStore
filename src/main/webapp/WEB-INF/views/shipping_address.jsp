<%@ include file="shippingaddress_header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="stag"%>
<%-- <%! String shipping1=null;
	String billing1=null;
%>
 --%>
<!--Address blocks -->
<script>
function proceed(){
var s=$('#editShipAddress').val();
var b=$('#editBillAddress').val();
if(s!==null && b!==null){
	document.getElementById("proceed").disabled=false;
}
else{
	
}
}
</script>

<div id="page-wrapper">
	<div class="main-page">
		<div class="typography">


			<div class="grid_3 grid_5 widget-shadow">


				<form method="get">
					<label for="selector1" class="col-sm-2 control-label">Shipping
						Address</label><input type="submit" id="editShip" name="editShip" value="edit"
						disabled="disabled" />

					<div class="sign-up2">
						<div class="col-sm-8">
							<select name="shipLine" id="shipLine" onchange="show()">
								<option value="${selected}" selected>${selected}</option>
								<c:forEach items="${addressLine1List}" var="role">
									<c:if test="${role != selected}">
										<option value="${role}">${role}</option>
									</c:if>
								</c:forEach>
							</select>

						</div>
					</div>
					<div class="clearfix"></div>

					<div id="ship1"></div>
					<div id="ship2"></div>
					<div id="ship3"></div>
					<div id="ship4"></div>
					<div id="ship5"></div>


					<input type="hidden" name="editShipAddress" id="editShipAddress" /> 
					

				</form>

				<form method="get">
					<label for="selector1" class="col-sm-2 control-label">Billing
						Address</label> <input type="submit" id="editBill" name="editBill"
						value="edit" disabled />
					<div class="sign-up2">

						<div class="col-sm-8">
							<select name="billLine" id="billLine" onchange="showBilling()">
								<option value="${selected}" selected>${selected}</option>
								<c:forEach items="${addressLine1List}" var="role">
									<c:if test="${role != selected}">
										<option value="${role}">${role}</option>
									</c:if>
								</c:forEach>
							</select>

						</div>
					</div>
					<div class="clearfix"></div>

					<div id="bill1"></div>
					<div id="bill2"></div>
					<div id="bill3"></div>
					<div id="bill4"></div>
					<div id="bill5"></div>
					<input type="hidden" name="editBillAddress" id="editBillAddress" />
				</form>
				<form action="addressController" method="post">


					<div class="sign-up2">

						<div class="col-sm-8">
							<%-- <form:select items="${shippingAddressLine1List}" path="billingId.addressLine1" class="form-control1" id="billLine" name="billLine" onchange="showBilling()">
										<input type="submit" value="Edit"/> --%>


							<input type="hidden" name="shipping1" id="shipping1" /> <input
								type="hidden" name="billing1" id="billing1" />


						</div>
						<div class="sub_home">
<!-- 
							<script>
								proceed();
							</script> -->
							<input type="submit" value="Proceed" id="proceed" />

							<div class="clearfix"></div>
						</div>

					</div>
					<div class="clearfix"></div>

				</form>

			</div>


		</div>
	</div>



	<!-- Add New Address -->

	<div class="main-page signup-page">

		<p class="creating"></p>
		<div class="sign-up-row widget-shadow">

			<form:form action="modifyAddressController" method="post"
				commandName="address" onsubmit="return check()">

				<form:input type="text" hidden="true" path="addressId" />

				<div class="sign-u">
					<div class="sign-up1">
						<h4>Line 1* :</h4>
					</div>
					<div class="sign-up2">

						<form:input type="text" path="addressLine1" />
						<p>
							<font color="red"><form:errors path="addressLine1" /></font>
						</p>

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="sign-u">
					<div class="sign-up1">
						<h4>Line 2 :</h4>
					</div>
					<div class="sign-up2">

						<form:input type="text" path="addressLine2" onsubmit="check()" />


					</div>
					<div class="clearfix"></div>
				</div>
				<div class="sign-u">
					<div class="sign-up1">
						<h4>City* :</h4>
					</div>
					<div class="sign-up2">

						<form:input type="text" path="city" />
						<p>
							<font color="red"><form:errors path="city" /></font>
						</p>

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="sign-u">
					<div class="sign-up1">
						<h4>Country * :</h4>
					</div>
					<div class="sign-up2">
						<div class="col-sm-8">
							<form:select id="country" path="country" class="form-control1">
								
								<option>${address.country}</option>
							</form:select>
							<p>
								<font color="red"><form:errors path="country" /></font>
							</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="sign-u">
					<div class="sign-up1">
						<h4>State * :</h4>
					</div>
					<div class="sign-up2">
						<div class="col-sm-8">
							<form:select id="state" path="state" class="form-control1">
								<option>${address.state}</option>
							</form:select>
							<p>
								<font color="red"><form:errors path="state" /></font>
							</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="sign-u">
					<div class="sign-up1">
						<h4>Zipcode * :</h4>
					</div>
					<div class="sign-up2">

						<form:input type="text" path="zipcode" />
						<p>
							<font color="red"><form:errors path="zipcode" /></font>
						</p>

					</div>
					<div class="clearfix"></div>
				</div>
				<div align="left" class="message">

					<c:if test="${not empty message}">
						<font color="red"><c:out value="${message}" /></font>
					</c:if>
				</div>
				<div class="sub_home">

					<input type="submit" value="Update" name="submit">

					<div class="clearfix"></div>
				</div>

			</form:form>
		</div>
	</div>
</div>

<%@ include file="myaccount_footer.jsp"%>

</body>




</html>