<!--
Author : Phani Mahesh Birudukota & W3Layouts
Email  : pbirudukota@miraclesoft.com
Date   : 02-26-2016
--> 
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!--MyAccountHeader_Miracle-->
<!DOCTYPE HTML>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="stag"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>My Account | Miracle Store</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />

<!-- CSS Files URL -->
<stag:url value="/resources/css/myaccount_custom.css" var="myaccountCustomJsCss" />
<stag:url value="/resources/css/myaccount_animate.css" var="myaccountAnimateCss" />
<stag:url value="/resources/css/myaccount_bootstrap.css" var="myaccountBootstrapCss" />
<stag:url value="/resources/css/myaccount_style.css" var="myaccountStyleCss" />
<stag:url value="/resources/css/myaccount_font-awesome.css" var="myaccountFontAwsomeCss" />
<!-- JS Files URL -->
<stag:url value="/resources/js/myaccount_jquery-1.11.1.min.js" var="myaccountJqueryJs" />
<stag:url value="/resources/js/myaccount_modernizr.custom.js" var="myaccountModernizerJs" />
<stag:url value="/resources/js/myaccount_wow.min.js" var="myaccountWowJs" />
<stag:url value="/resources/js/myaccount_Chart.js" var="myaccountChartJs" />
<stag:url value="/resources/js/myaccount_metisMenu.min.js" var="myaccountMetisJs" />
<stag:url value="/resources/js/myaccount_custom.js" var="myaccountCustomJs" />
<stag:url value="/resources/js/classie.js" var="myaccountClassieJs" />
<stag:url value="/resources/js/jquery.nicescroll.js" var="myaccountScrollJs" />
<stag:url value="/resources/js/scripts.js" var="myaccountScriptJs" />

<stag:url value="/resources/js/countries.js" var="countriesJs" />
<script src="${countriesJs}"></script>


<!--CSS Imports-->
<link href="${myaccountCustomJsCss}" rel="stylesheet" />
<link href="${myaccountAnimateCss}" rel="stylesheet" />
<link href="${myaccountBootstrapCss}" rel="stylesheet" />
<link href="${myaccountStyleCss}" rel="stylesheet" />
<link href="${myaccountFontAwsomeCss}" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>


<!--JS Imports-->
<script src="${myaccountJqueryJs}"></script>
<script src="${myaccountModernizerJs}"></script>
<script src="${myaccountWowJs}"></script>
<script src="${myaccountChartJs}"></script>
<script src="${myaccountMetisJs}"></script>
<script src="${myaccountCustomJs}"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script>
		 new WOW().init();
</script>
<script src="${myaccountClassieJs}"></script>
<script src="${myaccountScrollJs}"></script>
<script src="${myaccountScriptJs}"></script>


</head>


<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						<li>
							<a href="updateProfileProcess" class="active"><i class="fa fa-home nav_icon"></i>My Account</a>
						</li>
						
						<li>
							<a href="#"><i class="fa fa-th-large nav_icon"></i>Orders</a>
						</li>
						
						<li>
							<a href="#"><i class="fa fa-table nav_icon"></i>Wishlist</a>
						</li>
						
						<li>
							<a href="addressProcess" class="chart-nav"><i class="fa fa-bar-chart nav_icon"></i>Address Book</a>
						</li>
						<li>
							<a href="deleteProfileProcess"><i class="fa fa-table nav_icon"></i>Delete Account</a>
						</li>
					</ul>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<!--logo -->
				<div class="logo">
					<a href="/web/Products">
						<h1>Miracle Store</h1>
						<span>My Account</span>
					</a>
				</div>
				<!--//logo-->
				<!--search-box-->
				<div class="search-box">
					<form class="input">
						<input class="sb-search-input input__field--madoka" placeholder="Search..." type="search" id="input-31" />
						<label class="input__label" for="input-31">
							<svg class="graphic" width="100%" height="100%" viewBox="0 0 404 77" preserveAspectRatio="none">
								<path d="m0,0l404,0l0,77l-404,0l0,-77z"/>
							</svg>
						</label>
					</form>
				</div><!--//end-search-box-->
				<div class="clearfix"> </div>
			</div>
			<div class="header-right">
				<div class="profile_details_left"><!--notifications of menu start -->
					<div class="clearfix"> </div>
				</div>
				<!--notification menu end -->
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<!--<span class="prfil-img"><img src="images/a.png" alt=""> </span> Profile-Pic-Option-->
									<div class="user-name">
										<p><%=SecurityContextHolder.getContext().getAuthentication().getName() %></p>
										<!-- <span>UserId</span> -->
									</div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">							
								<li> <a href="#"><i class="fa fa-sign-out"></i> Logout</a> </li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->





