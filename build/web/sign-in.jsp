<%-- 
    Document   : sign-in
    Created on : Dec 18, 2017, 7:34:54 PM
    Author     : amir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
	
<!-- Mirrored from themesground.com/hexino/V2/sign-in.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 18 Dec 2017 12:08:07 GMT -->
<head>
		<!-- Meta -->
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
		<meta name="description" content="">
		<meta name="author" content="">
	    <meta name="keywords" content="MediaCenter, Template, eCommerce">
	    <meta name="robots" content="all">

	    <title>Hexino premium HTML5 & CSS3 Template</title>

            <jsp:include page="styles.jsp"/>
	</head>
    <body class="cnt-home">
		<!-- ============================================== HEADER ============================================== -->
                <jsp:include page="header.jsp"/>

<!-- ============================================== HEADER : END ============================================== -->
<div class="breadcrumb">
	<div class="container">
		<div class="breadcrumb-inner">
			<ul class="list-inline list-unstyled">
				<li><a href="home.html">Home</a></li>
				<li class='active'>Login</li>
			</ul>
		</div><!-- /.breadcrumb-inner -->
	</div><!-- /.container -->
</div><!-- /.breadcrumb -->


<div class="body-content">
	<div class="container">
		<div class="sign-in-page">
			<div class="row">
                            <c:if test="${not empty msg}">
							<div  class="alert alert-success alert-dismissible msg">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							  <h4><i class="icon fa fa-check"></i> Message :</h4>

							  <p>${msg}</p>
							</div>
							</c:if>
							<c:if test="${not empty msgLogin}">
							<div  class="alert alert-danger alert-dismissible msg">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							  <h4><i class="icon fa fa-check"></i> Message :</h4>

							  <p>${msgLogin}</p>
							</div>
							</c:if>
                            
				<!-- Sign-in -->			
<div class="col-md-6 col-sm-6 sign-in">
	<h4 class="">Sign in</h4>
	<p class="">Hello, Welcome to your account.</p>
				
        <form class="register-form outer-top-xs" role="form" method="POST" action="/GestionFormation/login">
		<div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Email Address <span>*</span></label>
		    <input type="email" name="usr" class="form-control unicase-form-control text-input" id="exampleInputEmail1" >

		</div>
	  	<div class="form-group">
		    <label class="info-title" for="exampleInputPassword1">Password <span>*</span></label>
		    <input type="password" name="pass" class="form-control unicase-form-control text-input" id="exampleInputPassword1" >
		</div>
		<div class="radio outer-xs">
		  	<label> 
		    	<input type="checkbox" name="optionsRadios" id="optionsRadios2" value="option2">Remember me!
		  	</label>
		  	<a href="#" class="forgot-password pull-right spacer">  Forgot your Password?</a>
		</div>
	  	<input type="submit" class="btn-upper btn btn-primary checkout-page-button btn-block" value="Login">
	</form>					
</div>
<!-- Sign-in -->

<!-- create a new account -->
<div class="col-md-6 col-sm-6 create-new-account">
	<h4 class="checkout-subtitle">Create a new account </h4>
	<p class="text title-tag-line">Create your new account.</p>
        <form class="register-form outer-top-xs" role="form" action="/GestionFormation/register" method="POST">
		<div class="form-group">
	    	<label class="info-title" for="exampleInputEmail2">Email Address <span>*</span></label>
	    	<input type="email" name="email" value="${email}" class="form-control unicase-form-control text-input" id="exampleInputEmail2" >
	    	<c:if test="${not empty msg_email}">
		    	<span class="help-block">${msg_email}</span>
		    </c:if>
	  	</div>
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">First name <span>*</span></label>
                    <input type="text" name="fname" value="${fname}" class="form-control unicase-form-control text-input" id="exampleInputEmail1" >
		</div>
            <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Last name <span>*</span></label>
		    <input type="text" name="lname" value="${lname}" class="form-control unicase-form-control text-input" id="exampleInputEmail1" >
		</div>
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Phone Number <span>*</span></label>
                    <input type="text" name="phone" value="${phone}"  class="form-control unicase-form-control text-input" id="exampleInputEmail1" >
		</div>
            <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Adress<span>*</span></label>
		    <input type="text" name="adress" value="${adress}"  class="form-control unicase-form-control text-input" id="exampleInputEmail1" >
		</div>
        <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Password <span>*</span></label>
		    <input type="password" name="pass1" class="form-control unicase-form-control text-input" id="exampleInputEmail1" >
		    <c:if test="${not empty msg_pass}">
		    	<span class="help-block">${msg_pass}</span>
		    </c:if>
		</div>
         <div class="form-group">
		    <label class="info-title" for="exampleInputEmail1">Confirm Password <span>*</span></label>
		    <input type="password" name="pass2" class="form-control unicase-form-control text-input" id="exampleInputEmail1" >
		    <c:if test="${not empty msg_pass}">
		    	<span class="help-block">${msg_pass}</span>
		    </c:if>
		</div>
	  	<button type="submit" class="btn-upper btn btn-primary checkout-page-button btn-block">Sign Up</button>
	</form>
	
	
</div>	
<!-- create a new account -->			</div><!-- /.row -->
		</div><!-- /.sigin-in-->
		<!-- ============================================== BRANDS CAROUSEL ============================================== -->

<!-- ============================================== BRANDS CAROUSEL : END ============================================== -->	</div><!-- /.container -->
</div><!-- /.body-content -->
        <jsp:include page="footer.jsp"/>
        <jsp:include page="scripts.jsp"/>
        <script type="text/javascript">
	      $(".msg").show().delay(5000).fadeOut();
	    </script>
	

</body>


</html>

