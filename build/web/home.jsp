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
    <title>Hexino premium HTML5 & CSS3 Template</title>
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
<div class="body-content outer-top-xs">
  <div class='container'>
    <div class='row'>
      <div class='col-md-3 sidebar'>
       <div class="sidebar-module-container">
                
                <div class="sidebar-filter">


                  <!-- ============================================== PRICE SILDER============================================== -->
<div class="sidebar-widget wow fadeInUp">
  <div class="widget-header">
    <h4 class="widget-title">Price Slider</h4>
  </div>
  <div class="sidebar-widget-body m-t-10">
    <div class="price-range-holder">
            <span class="min-max">
                 <span class="pull-left">$100.00</span>
                 <span class="pull-right">$1000.00</span>
            </span>
            <form action="home" method="POST">

            <input type="text" class="price-slider" value="" name="slider">
            
        </div><!-- /.price-range-holder -->
        <BUTTON type="submit" class="lnk btn btn-primary">Show Now</BUTTON>
        </form>
  </div><!-- /.sidebar-widget-body -->
</div><!-- /.sidebar-widget -->
<!-- ============================================== PRICE SILDER : END ============================================== -->

                  <!-- ============================================== PRODUCT TAGS ============================================== -->
<div class="sidebar-widget product-tag wow fadeInUp outer-top-vs">
  <h3 class="section-title">Product tags</h3>
  <div class="sidebar-widget-body outer-top-xs">
    <div class="tag-list">
    
    <c:forEach begin="1" end="${keywords.size()}" var="i">
      <a class="item" title="Phone" href="category.html">${keywords.get(i-1).mot}</a>
    </c:forEach>     

    </div><!-- /.tag-list -->
  </div><!-- /.sidebar-widget-body -->
</div><!-- /.sidebar-widget -->
<!-- ============================================== PRODUCT TAGS : END ============================================== -->  

<div class="home-banner">
<img src="assets/images/banners/LHS-banner.jpg" alt="Image">
</div> 

                </div><!-- /.sidebar-filter -->
              </div><!-- /.sidebar-module-container -->
            </div><!-- /.sidebar -->
      <div class='col-md-9'>

        <div class="clearfix filters-container m-t-10">
  <div class="row">
    <div class="col col-sm-6 col-md-2">
      <div class="filter-tabs">
        <ul id="filter-tabs" class="nav nav-tabs nav-tab-box nav-tab-fa-icon">

          <li  class="active"><a data-toggle="tab" href="#list-container"><i class="icon fa fa-th-list"></i>List</a></li>
        </ul>
      </div><!-- /.filter-tabs -->
    </div><!-- /.col -->
    <div class="col col-sm-12 col-md-6">
      <div class="col col-sm-3 col-md-6 no-padding">
        
      </div><!-- /.col -->
      <div class="col col-sm-3 col-md-6 no-padding">

      </div><!-- /.col -->
    </div><!-- /.col -->
    <div class="col col-sm-6 col-md-4 text-right">
      <div class="pagination-container">
  <ul class="list-inline list-unstyled">
    <li class="prev"><a href="#"><i class="fa fa-angle-left"></i></a></li>
    <li><a href="#">1</a></li>  
    <li class="active"><a href="#">2</a></li> 
    <li><a href="#">3</a></li>  
    <li><a href="#">4</a></li>  
    <li class="next"><a href="#"><i class="fa fa-angle-right"></i></a></li>
  </ul><!-- /.list-inline -->
</div><!-- /.pagination-container -->   </div><!-- /.col -->
  </div><!-- /.row -->
</div>
        <div class="search-result-container ">
          <div id="myTabContent" class="tab-content category-list">
            
              
            <div class="tab-pane active"  id="list-container">
              <div class="category-product">
              <c:choose >
                                <c:when test="${not empty formations}" >
                  <c:forEach begin="1" end="${formations.size()}" var="i">
                      <div class="category-product-inner wow fadeInUp">
      <div class="products">        
              <div class="product-list product">
  <div class="row product-list-row">
    <div class="col col-sm-4 col-lg-4">
      <div class="product-image">
        <div class="image">
          <img src="assets/images/FORMATION.png" alt="">
        </div>
      </div><!-- /.product-image -->
    </div><!-- /.col -->
    <form method="POST" action="home">
    <div class="col col-sm-8 col-lg-8">
      <div class="product-info">
        <h3 class="name"><a href="detail.html">${formations.get(i-1).getNom()}</a></h3>
        <div class="rating rateit-small"></div>
        <div class="product-price"> 
          <span class="price">${formations.get(i-1).getPrice()} DT</span>
                      
        </div><!-- /.product-price -->
        <div class="description m-t-10">${formations.get(i-1).getDescription()}</div>
                        <div class="cart clearfix animate-effect">
          <div class="action">
          
            <ul class="list-unstyled">
              <li class="add-cart-button btn-group">
              <input type="hidden" name="add-cart" value="${formations.get(i-1).getId()}">
                <button class="btn btn-primary cart-btn" name="add-cart" type="submit">Add to cart</button>
              </li> 
                      <li class="lnk wishlist">
                <a class="add-to-cart" href="detail.html" title="Wishlist">
                   <i class="icon fa fa-heart"></i>
                </a>
              </li>


              <li class="lnk">
                <a class="add-to-cart" href="detail.html" title="Compare">
                    <i class="fa fa-signal"></i>
                </a>
              </li>
            </ul>
          </div><!-- /.action -->
          </form>
        </div><!-- /.cart -->
                
      </div><!-- /.product-info --> 
    </div><!-- /.col -->
  </div><!-- /.product-list-row -->
  <div class="tag new"><span>new</span></div>        </div><!-- /.product-list -->
      </div><!-- /.products -->
    </div><!-- /.category-product-inner -->
    </c:forEach>
    </c:when>
    <c:when test="${empty formations}">
    <div >
    <h1>Sorry</h1>
    <h3>We could not find any product !</h3>
    </div>
    </c:when>
</c:choose>        
              
              </div><!-- /.category-product -->
            </div><!-- /.tab-pane #list-container -->
          </div><!-- /.tab-content -->
          <div class="clearfix filters-container">
            
              <div class="text-right">
                     <div class="pagination-container">
  <ul class="list-inline list-unstyled">
    <li class="prev"><a href="#"><i class="fa fa-angle-left"></i></a></li>
    <li><a href="#">1</a></li>  
    <li class="active"><a href="#">2</a></li> 
    <li><a href="#">3</a></li>  
    <li><a href="#">4</a></li>  
    <li class="next"><a href="#"><i class="fa fa-angle-right"></i></a></li>
  </ul><!-- /.list-inline -->
</div><!-- /.pagination-container -->               </div><!-- /.text-right -->
            
          </div><!-- /.filters-container -->

        </div><!-- /.search-result-container -->



      </div><!-- /.col -->
    </div><!-- /.row -->
  </div><!-- /.container -->



</div><!-- /.body-content -->
          
   

    <jsp:include page="footer.jsp"/>
    <jsp:include page="scripts.jsp"/>
  </body>
</html>
