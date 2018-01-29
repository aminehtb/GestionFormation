<%-- 
    Document   : style
    Created on : Dec 18, 2017, 7:41:30 PM
    Author     : amine
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/>
<body >
  <div class="container">
    <div class="card card-login mx-auto mt-5">
   
							<c:if test="${not empty msg}">
							<div  class="alert  alert-dismissible msg card text-white bg-danger	">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							  <h4><i class="icon fa fa-check"></i> Message :</h4>

							  <p>${msg}</p>
							</div>
							</c:if>

      <div class="card-header">Login</div>
      <div class="card-body">
        <form action="/GestionFormation/admin" method="POST">
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="Enter email" name="usr" required="true">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="exampleInputPassword1" name="pass" type="password" placeholder="Password" required="true">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
          <BUTTON class="btn btn-primary btn-block" type="submit">Login</BUTTON>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Register an Account</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
 

  <jsp:include page="script.jsp"/>
<script type="text/javascript">
	      $(".msg").show().delay(5000).fadeOut();
	    </script>
</body>

