<%@ include file="header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--checkout_Banner -->
<!-- spring form tag prefix : form -->
<!-- spring tag prefix : stag -->

<div class="container">
	<div class="check">
		<div class="col-md-9 cart-items">
			<h1>My Shopping Bag</h1>

			<c:if test="${productcount==0}">
				<font color="red">
					<h1>NO ITEMS IN CART</h1>
				</font>
			</c:if>
			<c:forEach items="${cartdetails}" var="cartvalues" varStatus="status">

				<c:if test="${cartvalues.getProdquant()>0}">
					<div class="cart-sec simpleCart_shelfItem"></div>
					<div class="cart-item cyc">

						<img src=${images.get(status.index) } class="img-responsive"
							alt="" />
					</div>

					<div class="cart-item-info">

						<h3>
							<a href="#">${cartvalues.getProdname()}</a>
						</h3>

						<p>Product Description</p>
						<h3>${productdescription.get(status.index)}</h3>
						<c:if test="${not empty result}">
                         <c:if test="${result.get(status.index)<10}">
							</form>
							<font color="red">
								<h1>only ${result.get(status.index)} available in stock</h1>

							</font>
						</c:if>
						</c:if>
						<h3>${cartvalues.getProdprice()}</h3>
						<ul class="qty">

							<form action="Cartupdate">
							   
								Quantity : <input type="number" name="quantity" min="0" max="5" value="${cartvalues.getProdquant()}" />
								 <input type="hidden" name="productid" value="${cartvalues.getProdid()}"> 
								 <input type="submit" id="Update" name="update" value="Update" />
                             </form>
								<form action="Cartupdate">
									<input type="hidden" name="productid" value="${cartvalues.getProdid()}"> 
									<input type="submit" value="Delete" />
								</form>
						</ul>
					</div>
					<div class="clearfix"></div>

				</c:if>

			</c:forEach>

		</div>




		<div class="col-md-3 cart-total">

			<div class="price-details">
				<h3>Price Details</h3>
				<h4>TOTAL</h4>
				<c:if test="${totalprice>0 }">
					<span class="total1"><h2>$ ${totalprice}</h2></span>
				</c:if>
				<c:if test="${totalprice<=0 }">
					<span class="total1"><h2>$ 0.00</h2></span>
				</c:if>
				<!-- <span>Tax</span>
				 <span class="total1">---</span> -->

				<div class="clearfix"></div>
			</div>
			<ul class="total_price">
				<!-- <li class="last_price"> <h4>TOTAL</h4></li>	
			   <li class="last_price"><span>6350.00</span></li> -->
				<div class="clearfix"></div>
			</ul>


			<div class="clearfix"></div>
			<a class="order" href="addressController">Place Order</a> <a class="order"
				href="Products">Continue Shopping</a>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>