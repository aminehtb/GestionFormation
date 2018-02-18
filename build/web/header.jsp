<%-- 
    Document   : header
    Created on : Dec 18, 2017, 7:35:15 PM
    Author     : amir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header class="header-style-1">

	<!-- ============================================== TOP MENU ============================================== -->
<div class="top-bar animate-dropdown">
	<div class="container">
		<div class="header-top-inner">
			<div class="cnt-account">
				<ul class="list-unstyled">
					<c:choose >
                                <c:when test="${empty user}" >
                                	<li><a href="sign-in.jsp"><i class="icon fa fa-user"></i>My Account</a></li>
                                </c:when>
                                <c:when test="${not empty user}" >
                                	<li><a href="#"><i class="icon fa fa-user"></i>${user.getFirstname()}</a></li>
                                </c:when>
                  	</c:choose>
					<li><a href="checkout"><i class="icon fa fa-check"></i>Checkout</a></li>
					<c:choose >
                                <c:when test="${empty user}" >
                                	<li><a href="sign-in.jsp"><i class="icon fa fa-lock"></i>Login</a></li>
                                </c:when>
                                <c:when test="${not empty user}" >
                                	<li><a href="logout"><i class="icon fa fa-lock"></i>Logout</a></li>
                                </c:when>
                  	</c:choose>
					
				</ul>
			</div><!-- /.cnt-account -->

			
			<div class="clearfix"></div>
		</div><!-- /.header-top-inner -->
	</div><!-- /.container -->
</div><!-- /.header-top -->
<!-- ============================================== TOP MENU : END ============================================== -->
	<div class="main-header">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-3 logo-holder">
					<!-- ============================================================= LOGO ============================================================= -->
<div class="logo">
	<a href="home">
		
		<img src="assets/images/logo.png" alt="">

	</a>
</div><!-- /.logo -->
<!-- ============================================================= LOGO : END ============================================================= -->				</div><!-- /.logo-holder -->

				<div class="col-xs-12 col-sm-12 col-md-7 top-search-holder">
				
					<!-- /.contact-row -->
<!-- ============================================================= SEARCH AREA ============================================================= -->
<div class="search-area">
    <form>
        <div class="control-group">

            <ul class="categories-filter animate-dropdown">
                <li class="dropdown">

                    <a class="dropdown-toggle"  data-toggle="dropdown" href="category.html">Categories <b class="caret"></b></a>

                    <ul class="dropdown-menu" role="menu" >

                        <li class="menu-header">All Categories</li>
                        <c:forEach begin="1" end="${categories.size()}" var="i">
                        	<li role="presentation"><a role="menuitem" tabindex="-1" href="home?filter='${categories.get(i-1).nom}'">${categories.get(i-1).nom}</a></li>
						</c:forEach>
              
                    </ul>
                </li>
            </ul>

            <form method="GET" action="home">
	    		<input class="search-field" name="search" type="text" value='${search}' placeholder="Search here..." />  
            	 <button class="button search-button" > </button>
            	
            </form>

        </div>
    </form>
</div><!-- /.search-area -->
<!-- ============================================================= SEARCH AREA : END ============================================================= -->				</div><!-- /.top-search-holder -->

				<div class="col-xs-12 col-sm-12 col-md-2 animate-dropdown top-cart-row">
					<!-- ============================================================= SHOPPING CART DROPDOWN ============================================================= -->

	<div class="dropdown dropdown-cart">
		<a href="#" class="dropdown-toggle lnk-cart" data-toggle="dropdown">
			<div class="items-cart-inner">
            <div class="basket">
					<i class="glyphicon glyphicon-shopping-cart"></i>
				</div>
				<div class="basket-item-count"><span class="count">${panier.size()}</span></div>
				<div class="total-price-basket">
					<span class="lbl">cart -</span>
					<span class="total-price">
						<span class="sign">$</span><span class="value">${totalPrice}</span>
					</span>
				</div>
				
			
		    </div>
		</a>
		<ul class="dropdown-menu">
			<li>
				<div class="cart-item product-summary">
					<div class="row">
						<div class="col-xs-4">
							<div class="image">
								<a href="detail.html"><img src="assets/images/cart.jpg" alt=""></a>
							</div>
						</div>
						<div class="col-xs-7">
							
							<h3 class="name"><a href="index8a95.html?page-detail">Simple Product</a></h3>
							<div class="price">$600.00</div>
						</div>
						<div class="col-xs-1 action">
							<a href="#"><i class="fa fa-trash"></i></a>
						</div>
					</div>
				</div><!-- /.cart-item -->
				<div class="clearfix"></div>
			<hr>
		
			<div class="clearfix cart-total">
				<div class="pull-right">
					
						<span class="text">Sub Total :</span><span class='price'>$600.00</span>
						
				</div>
				<div class="clearfix"></div>
					
				<a href="checkout.html" class="btn btn-upper btn-primary btn-block m-t-20">Checkout</a>	
			</div><!-- /.cart-total-->
					
				
		</li>
		</ul><!-- /.dropdown-menu-->
	</div><!-- /.dropdown-cart -->

<!-- ============================================================= SHOPPING CART DROPDOWN : END============================================================= -->				</div><!-- /.top-cart-row -->
			</div><!-- /.row -->

		</div><!-- /.container -->

	</div><!-- /.main-header -->

	<!-- ============================================== NAVBAR ============================================== -->
<div class="header-nav animate-dropdown">
    <div class="container">
        <div class="yamm navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button data-target="#mc-horizontal-menu-collapse" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="nav-bg-class">
                <div class="navbar-collapse collapse" id="mc-horizontal-menu-collapse">
	<div class="nav-outer">
		<ul class="nav navbar-nav">
			<li class="active dropdown yamm-fw">
				<a href="home"  class="dropdown-toggle" data-toggle="dropdown">Home</a>
				
			</li>
			<li class="dropdown yamm mega-menu">
				<a href="checkout"  class="dropdown-toggle" data-toggle="dropdown">Checkout</a>
              
				
			</li>

			<li class="dropdown mega-menu">
				<a href="category.html"  data-hover="dropdown" class="dropdown-toggle" data-toggle="dropdown">contact
				</a>
             
			</li>
			<li class="dropdown hidden-sm">
				
				<a href="category.html">track orders
				</a>
			</li>

			<li class="dropdown hidden-sm">
				<a href="category.html">Terms & Conditions</a>
			</li>

			<li class="dropdown">
				<a href="contact.html">FAQ</a>
			</li>
           
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">Pages</a>
				<ul class="dropdown-menu pages">
					<li>
						<div class="yamm-content">
							<div class="row">
								
									<div class="col-xs-12 col-menu">
	                                  <ul class="links">
		                                  	<li><a href="home">Home</a></li>
											<li><a href="category.html">Category</a></li>
											<li><a href="detail.html">Detail</a></li>
											<li><a href="shopping-cart.html">Shopping Cart Summary</a></li>
                                            <li><a href="checkout.html">Checkout</a></li>
											<li><a href="blog.html">Blog</a></li>
											<li><a href="blog-details.html">Blog Detail</a></li>
											<li><a href="contact.html">Contact</a></li>
                                            <li><a href="sign-in.html">Sign In</a></li>
											<li><a href="my-wishlist.html">Wishlist</a></li>
											<li><a href="terms-conditions.html">Terms and Condition</a></li>
											<li><a href="track-orders.html">Track Orders</a></li>
											<li><a href="product-comparison.html">Product-Comparison</a></li>
		                                  	<li><a href="faq.html">FAQ</a></li>
											<li><a href="404.html">404</a></li>
											
	                                  </ul>
									</div>
									
									
								
							</div>
						</div>
					</li>
                    
                   
					
				</ul>
			</li>
            
					
			
		</ul><!-- /.navbar-nav -->
		<div class="clearfix"></div>				
	</div><!-- /.nav-outer -->
</div><!-- /.navbar-collapse -->


            </div><!-- /.nav-bg-class -->
        </div><!-- /.navbar-default -->
    </div><!-- /.container-class -->

</div><!-- /.header-nav -->
<!-- ============================================== NAVBAR : END ============================================== -->

</header>
