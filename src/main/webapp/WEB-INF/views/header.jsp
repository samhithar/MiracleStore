<!--
Author : Phani Mahesh Birudukota & W3Layouts
Email  : pbirudukota@miraclesoft.com
Date   : 02-22-2016
--> 

<!--Header_Miracle-->

<!DOCTYPE HTML>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="stag"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Miracle Store</title>

<stag:url value="/resources/css/style.css" var="mainCss" />
<stag:url value="/resources/css/megamenu.css" var="menuCss" />
<stag:url value="/resources/css/bootstrap.css" var="bootstrapCss" />
<stag:url value="/resources/js/megamenu.js" var="megaJs" />
<stag:url value="/resources/js/simpleCart.min.js" var="mainJs" />
<stag:url value="/resources/js/jquery-1.11.1.min.js" var="jqueryJs" />
<stag:url value="/resources/css/creditstyle.css" var="creditCss" />
<stag:url value="/resources/css/creditreset.css" var="creditresetCss" />
<stag:url value="/resources/css/creditbootstrap.css" var="CreditbootstrapCss" />
<stag:url value="/resources/js/creditindex.js" var="creditindexJs" />


<link href="${creditCss}" rel="stylesheet" />
<link href="${creditresetCss}" rel="stylesheet" />
<link href="${CreditbootstrapCss}" rel="stylesheet" />
<script src="${creditindexJs}"></script>
<link href="${mainCss}" rel="stylesheet" />
<link href="${menuCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<script src="${megaJs}"></script>
<script src="${mainJs}"></script>
<script src="${jqueryJs}"></script>
	
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>


<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>

<!-- start menu -->
<script>$(document).ready(function(){$(${megaJs}).megamenu();});</script>
</head>
<body>
<div class="header_top">
	<div class="container">
		<div class="one-fifth column row_1"> 
	    </div>
         <div class="cssmenu">
			<ul>
			    <li class="active"><a href="updateProfileProcess">My Account</a></li>
				
				<li class="active"><a href="<stag:url value="j_spring_security_logout" />" >Logout</a></li>
			</ul>
		 </div>
	</div>
</div>	
<div class="wrap-box"></div>
<div class="header_bottom">
	    <div class="container">
			<div class="col-xs-8 header-bottom-left">
				<div class="col-xs-2 logo">
					<h1><a href="loginSuccess"><span>Miracle</span>Store</a></h1>
				</div>
				<div class="col-xs-6 menu">
		            <ul class="megamenu skyblue">
				      <li class="active grid"><a class="color1" href="/web/Products">Men</a>
					</li>
				    <li class="grid"><a class="color2" href="/web/Products">Women</a>
				</li>
				<li><a class="color4" href="#">About</a></li>		<!-- about.html -->				
				<li><a class="color5" href="#">Blog</a></li>		<!-- 404.html -->
				<li><a class="color6" href="#">Support</a></li>		<!-- contact.html -->
			  </ul> 
			</div>
		</div>
	    <div class="col-xs-4 header-bottom-right">
	       <div class="box_1-cart">
		     <div class="box_11"><a href="/web/cart">
		      <h4><p>Cart: <span><div>${totalprice}</div> <div>Items:${productcount}</div></span>
		      </a></div>
	          <p class="empty"><a href="javascript:;" class="simpleCart_empty">Clear Cart</a></p>
	          <div class="clearfix"> </div>
	        </div>
	        <div class="search">	  
				<input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" value="Subscribe" id="submit" name="submit">
				<div id="response"> </div>
		     </div>
	         <div class="clearfix"></div>
       </div>
        <div class="clearfix"></div>
	 </div>
</div>
