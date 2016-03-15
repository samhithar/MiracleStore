<%@ include file="myaccount_header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib  uri="http://www.springframework.org/tags" prefix="stag"%>

<!--Address blocks -->

<script>
function limit(element)
{
    var max_chars = 5;

    if(element.value.length > max_chars) {
        element.value = element.value.substr(0, max_chars);
    }
}
</script>


<div id="page-wrapper">
			<div class="main-page">
			<div class="typography">
			<div class="grid_3 grid_5 widget-shadow">
					<h3 class="hdg">Address</h3>
				
					<table style="width:100%">
					<tr>
					
					<c:forEach items="${customerAddressList}" var="customerAddress">
										
					<td>					
					
					<div class="well">
					${customerAddress.addressLine1}<br/>
										
					<c:if test ="${not empty customerAddress.addressLine2}">
						${customerAddress.addressLine2}<br/>
					</c:if>
					
					${customerAddress.city}<br/>
					${customerAddress.state} - ${customerAddress.zipcode}<br/>
					${customerAddress.country}	<br/>
					
					
					</div>
					<div class="clearfix"> </div>
					
					
					<div class="clearfix"> </div>
					
					<form method=get>					
					<input type = "hidden" name = "editAddress"  value = "${customerAddress.addressId}"/>
					<input type="submit" name="edit" value="Edit"/>															
					<input type = "hidden" name = "delAddress"  value = "${customerAddress.addressId}"/>
					<input type="submit" name="delete" value="Delete"/>					
					</form>
					<br/>
					</td>
					
									
					</c:forEach>
					</tr>
					</table>							
						<div class="clearfix"> </div>
				
					
			</div>
			
</div>
</div>


<!-- Add New Address -->

			<div class="main-page signup-page">
			
				<p class="creating"></p>
				<div class="sign-up-row widget-shadow">
					<form:form action="addressProcess" method="post" commandName="address" >
					
					<form:input type="text" hidden="true" path="addressId" />
					
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Line 1* :</h4>
						</div>
						<div class="sign-up2">
							
								<form:input type="text" path="addressLine1" />
								<p><font color="red"><form:errors path="addressLine1"/></font></p>
							
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Line 2 :</h4>
						</div>
						<div class="sign-up2">
							
								<form:input type="text" path="addressLine2"/>
								
							
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>City :</h4>
						</div>
						<div class="sign-up2">
							
								<form:input type="text" path="city" />
								<p><font color="red"><form:errors path="city"/></font></p>
							
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Country * :</h4>
						</div>
						<div class="sign-up2">
							<div class="col-sm-8"><form:select id="country" path="country" class="form-control1">
							 		<option>${country}</option>
								<!--  <option>${address.country}</option> --> 
								 	</form:select>
									<p><font color="red"><form:errors path="country"/></font></p>
									</div>
						</div>
						<div class="clearfix"> </div>
					</div>
					
					<div class="sign-u">
						<div class="sign-up1">
							<h4>State * :</h4>
						</div>
						<div class="sign-up2">
							<div class="col-sm-8"><form:select id="state" path="state" class="form-control1">
							<%-- <%if(request.getParameter("edit")!=null){ %>
								<option>${address.state}</option>
								<%} %>	 --%>
										<option>${state}</option>								
									</form:select>
									<p><font color="red"><form:errors path="state"/></font></p>
									</div>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Zipcode * :</h4>
						</div>
						<div class="sign-up2">
						
								<form:input type="number" path="zipcode" onkeydown="limit(this);" onkeyup="limit(this);"/>
								<p><font color="red"><form:errors path="zipcode"/></font></p>
							
						</div>
						<div class="clearfix"> </div>
					</div>
					
					<div class="sub_home">
						
							<input type="submit" value="Update">
						
						<div class="clearfix"> </div>
					</div>
					
					</form:form>
				</div>
			</div>
		</div>

<%@ include file="myaccount_footer.jsp" %>