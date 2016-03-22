<%@ include file="./header.jsp" %>


<!-- spring form tag prefix : form -->
<!-- spring tag prefix : stag -->

<!--Super Container-->
<div class="single_top">
	 <div class="container"> 
	      <div class="single_grid">
				<div class="grid images_3_of_2">
				  <img src=${image} class="img-responsive" alt=""/>
						<!-- <ul id="etalage">
							<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image" src="images/s1.jpg" class="img-responsive" />
									<img class="etalage_source_image" src="images/s1.jpg" class="img-responsive" title="" />
								</a>
							</li>
							<li>
								<img class="etalage_thumb_image" src="images/s2.jpg" class="img-responsive" />
								<img class="etalage_source_image" src="images/s2.jpg" class="img-responsive" title="" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="images/s3.jpg" class="img-responsive"  />
								<img class="etalage_source_image" src="images/s3.jpg"class="img-responsive"  />
							</li>
						    <li>
								<img class="etalage_thumb_image" src="images/s4.jpg" class="img-responsive"  />
								<img class="etalage_source_image" src="images/s4.jpg"class="img-responsive"  />
							</li>
						</ul> -->
						 <div class="clearfix"></div>		
				  </div> 
				  <div class="desc1 span_3_of_2">
				  	<ul class="back">
                	  <li><i class="back_arrow"> </i><a href="/web/Products">Back</a></li>
                    </ul>
					<h1>${products.name}</h1>
					<h1>product description</h1>
					<h1>${description}</h1>
			         <div class="simpleCart_shelfItem">
			         	<div class="price_single">
						  <div class="head"><h2><span class="amount item_price">${products.price} USD</span></h2></div>
						 <%--  <div class="head_desc"><a href="#">12 reviews</a><img src="${image}" alt=""/></li></div> --%>
					       <div class="clearfix"></div>
					     </div>
			            <form action="${pageContext.request.contextPath}/addtocart" method="post">
						Quantity : <input type="number" name="quantity" min= "0" max="5" value="1" />
						<input type="hidden" name="productid" value="${products.id}" >
						<input type="submit" value="Add to cart"/>
						</form>
			         </div>
				</div>
          	    <div class="clearfix"></div>
</div>
</div>				
</div>
<%@ include file="./footer.jsp" %>