<%--
    Document   : sign-in
    Created on : Dec 18, 2017, 7:34:54 PM
    Author     : amir
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
  <head>
  <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keywords" content="MediaCenter, Template, eCommerce">
    <meta name="robots" content="all">
    <title>${title}</title>
    <jsp:include page="styles.jsp"/>
  </head>
  <body class="cnt-home">
    <jsp:include page="header.jsp"/>
    <div class="body-content outer-top-xs">
      <div class="breadcrumb">
  <div class="container">
    <div class="breadcrumb-inner">
      <ul class="list-inline list-unstyled">
        <li class='active'><a href="#">Home</a></li>
      </ul>
    </div><!-- /.breadcrumb-inner -->
  </div><!-- /.container -->
</div><!-- /.breadcrumb -->

<!-- ============================================== HEADER : END ============================================== -->
<div class="breadcrumb">
	<div class="container">
		<div class="breadcrumb-inner">
			<ul class="list-inline list-unstyled">
				<li><a href="#">Home</a></li>
				<li class='active'>Shopping Cart</li>
			</ul>
		</div><!-- /.breadcrumb-inner -->
	</div><!-- /.container -->
</div><!-- /.breadcrumb -->

<div class="body-content outer-top-xs">
	<div class="container">
		<div class="row ">
			<div class="shopping-cart">
				<div class="shopping-cart-table ">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th class="cart-product-name item">Product Name</th>
					<th class="cart-sub-total item">Total</th>
					<th class="cart-total last-item">Action</th>
				</tr>
			</thead><!-- /thead -->
			<tfoot>
				<tr>
					<td colspan="7">
						<div class="shopping-cart-btn">
							<span class="">
								<a href="home" class="btn btn-upper btn-primary pull-right outer-right-xs">Continue Shopping</a>
							</span>
						</div><!-- /.shopping-cart-btn -->
					</td>
				</tr>
			</tfoot>
			<tbody>
			<c:forEach begin="1" end="${formation_panier.size()}" var="i">
				<tr>
					<td class="cart-product-name-info">
						<h4 class='cart-product-description'><a href="detail.html">${formation_panier.get(i-1).getNom()}</a></h4>
						<div class="row">
							<div class="col-sm-4">
								<div class="rating rateit-small"></div>
							</div>
						</div><!-- /.row -->
					</td>
					<td class="cart-product-grand-total"><span class="cart-grand-total-price">${formation_panier.get(i-1).getPrice()} DT</span></td>
					<td class="cart-product-edit">
					<a href="checkout?action=d&pk=${formation_panier.get(i-1).getId()}" class="product-edit">delete</a></br>
					<a href="checkout?action=p&pk=${formation_panier.get(i-1).getId()}" class="product-edit">pay it</a>
					</td>
				</tr>
				</c:forEach>
			</tbody><!-- /tbody -->
		</table><!-- /table -->
	</div>
</div><!-- /.shopping-cart-table -->



      </div><!-- /.col -->
    </div><!-- /.row -->
  </div><!-- /.container -->



</div><!-- /.body-content -->
          
   

    <jsp:include page="footer.jsp"/>
    <jsp:include page="scripts.jsp"/>
  </body>
</html>
