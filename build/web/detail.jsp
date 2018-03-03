<%-- 
    Document   : detail
    Created on : Jan 18, 2018, 7:29:41 PM
    Author     : amine
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    
<!-- Mirrored from themesground.com/hexino/V2/detail.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 18 Dec 2017 12:07:23 GMT -->
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
        <link href="assets/css/lightbox.css" rel="stylesheet">
        


    </head>
    <body class="cnt-home">
    <jsp:include page="header.jsp"/>

<!-- ============================================== HEADER : END ============================================== -->
<div class="breadcrumb">
    <div class="container">
        <div class="breadcrumb-inner">
            <ul class="list-inline list-unstyled">
                <li><a href="home">Home</a></li>
                <li class='active'>Detail</li>
            </ul>
        </div><!-- /.breadcrumb-inner -->
    </div><!-- /.container -->
</div><!-- /.breadcrumb -->
<div class="body-content outer-top-xs">
    <div class='container'>
        <div class='row single-product'>

            <div class='col-md-12'>
            <div class="detail-block">
                <div class="row  wow fadeInUp">
                
                         <div class="col-xs-12 col-sm-6 col-md-5 gallery-holder">
    <div class="product-item-holder size-big single-product-gallery small-gallery">

        <div id="owl-single-product">
            <div class="single-product-gallery-item" id="slide1">
                <a data-lightbox="image-1" data-title="Gallery" href="assets/images/FORMATION.png">
                    <img class="img-responsive" alt="" src="assets/images/blank.gif" data-echo="assets/images/FORMATION.png"" />
                </a>
            </div><!-- /.single-product-gallery-item -->

        </div>
        <!-- /.single-product-slider -->



    </div><!-- /.single-product-gallery -->
</div><!-- /.gallery-holder -->                 
                    <div class='col-sm-6 col-md-7 product-info-block'>
                        <div class="product-info">
                            <h1 class="name">${obj.getNom()}</h1>
                            
                            <div class="rating-reviews m-t-20">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="rating rateit-small"></div>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="reviews">
                                            <a href="#" class="lnk">(13 Reviews)</a>
                                        </div>
                                    </div>
                                </div><!-- /.row -->        
                            </div><!-- /.rating-reviews -->

                            <div class="stock-container info-container m-t-10">
                                <div class="row">
                                    <div class="col-sm-2">
                                        <div class="stock-box">
                                            <span class="label">Places Available :</span>
                                        </div>  
                                    </div>
                                    <div class="col-sm-9">
                                        <div class="stock-box">
                                            <span class="value">${obj.getPlaces()}</span>
                                        </div>  
                                    </div>
                                </div><!-- /.row -->    
                            </div><!-- /.stock-container -->

                            <div class="description-container m-t-20">
                                ${obj.getDescription()}
                            </div><!-- /.description-container -->

                            <div class="price-container info-container m-t-20">
                                <div class="row">
                                    

                                    <div class="col-sm-6">
                                        <div class="price-box">
                                            <span class="price">$${obj.getPrice()}</span>
                                            <!-- <span class="price-strike">$900.00</span> -->
                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <div class="favorite-button m-t-10">
                                            <a class="btn btn-primary" data-toggle="tooltip" data-placement="right" title="Wishlist" href="#">
                                                <i class="fa fa-heart"></i>
                                            </a>
                                            <a class="btn btn-primary" data-toggle="tooltip" data-placement="right" title="Add to Compare" href="#">
                                               <i class="fa fa-signal"></i>
                                            </a>
                                            <a class="btn btn-primary" data-toggle="tooltip" data-placement="right" title="E-mail" href="#">
                                                <i class="fa fa-envelope"></i>
                                            </a>
                                        </div>
                                    </div>

                                </div><!-- /.row -->
                            </div><!-- /.price-container -->

                            <div class="quantity-container info-container">
                                <div class="row">
                                    <c:if test="${in_panier}">
                                        <a href="detail?pk=${obj.getId()}&action=cart" class="btn btn-primary" disabled="true"><i class="fa fa-shopping-cart inner-right-vs"></i> ADD TO CART</a>
                                    </c:if>
                                    <c:if test="${not in_panier}">
                                    <a href="detail?pk=${obj.getId()}&action=cart" class="btn btn-primary"><i class="fa fa-shopping-cart inner-right-vs"></i> ADD TO CART</a>
                                    </c:if>

                                    
                                </div><!-- /.row -->
                            </div><!-- /.quantity-container -->

                            

                            

                            
                        </div><!-- /.product-info -->
                    </div><!-- /.col-sm-7 -->
                </div><!-- /.row -->
                </div>
                
                <div class="product-tabs inner-bottom-xs  wow fadeInUp">
                    <div class="row">
                        <div class="col-sm-3">
                            <ul id="product-tabs" class="nav nav-tabs nav-tab-cell">
                                <li class="active"><a data-toggle="tab" href="#description">DESCRIPTION</a></li>
                                <li><a data-toggle="tab" href="#program">Program</a></li>
                                <li><a data-toggle="tab" href="#review">REVIEW</a></li>

                            </ul><!-- /.nav-tabs #product-tabs -->
                        </div>
                        <div class="col-sm-9">

                            <div class="tab-content">
                                
                                <div id="description" class="tab-pane in active">
                                    <div class="product-reviews">
                                        <div class="reviews">
                                                <div class="review">
                                        ${obj.getDescription()}
                                        </div>
                                        </div>

                                    </div>  
                                </div><!-- /.tab-pane -->
                                <div id="program" class="tab-pane">
                                    <div class="product-tab">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th class="cart-product-name item">Nom</th>
                                                        <th class="cart-product-name item">Du</th>
                                                        <th class="cart-sub-total item">Au</th>
                                                        <th class="cart-total last-item">Tache</th>
                                                    </tr>
                                                </thead><!-- /thead -->
                                                <tbody>
                                                    <c:forEach begin="1" end="${prog.size()}" var="i">
                                                        <tr>
                                                            <td class="cart-product-grand-total"><span class="cart-grand-total-price">${prog.get(i-1).getTitre()} </span></td>
                                                            <td class="cart-product-grand-total"><span class="cart-grand-total-price">${prog.get(i-1).getDu()} </span></td>
                                                            <td class="cart-product-grand-total"><span class="cart-grand-total-price">${prog.get(i-1).getAu()} </span></td>
                                                            <td class="cart-product-grand-total"><span class="cart-grand-total-price">${prog.get(i-1).getTache()} </span></td>
                                                        </tr>
                                                        </c:forEach>
                                                    </tbody><!-- /tbody -->
                                            </table>
                                        </div>
                                        </div>
                                        </div>
                                <div id="review" class="tab-pane">
                                    <div class="product-tab">
                                                                                
                                        <div class="product-reviews">
                                            <h4 class="title">Customer Reviews</h4>

                                            <div class="reviews">
                                                <div class="review">
                                                    <div class="review-title"><span class="summary">We love this product</span><span class="date"><i class="fa fa-calendar"></i><span>1 days ago</span></span></div>
                                                    <div class="text">"Lorem ipsum dolor sit amet, consectetur adipiscing elit.Aliquam suscipit."</div>
                                                                                                        </div>
                                            
                                            </div><!-- /.reviews -->
                                        </div><!-- /.product-reviews -->
                                        

                                        
                                        <div class="product-add-review">
                                            <h4 class="title">Write your own review</h4>
                                            <div class="review-table">
                                                <div class="table-responsive">
                                                    <table class="table">   
                                                        <thead>
                                                            <tr>
                                                                <th class="cell-label">&nbsp;</th>
                                                                <th>1 star</th>
                                                                <th>2 stars</th>
                                                                <th>3 stars</th>
                                                                <th>4 stars</th>
                                                                <th>5 stars</th>
                                                            </tr>
                                                        </thead>    
                                                        <tbody>
                                                            <tr>
                                                                <td class="cell-label">Quality</td>
                                                                <td><input type="radio" name="quality" class="radio" value="1"></td>
                                                                <td><input type="radio" name="quality" class="radio" value="2"></td>
                                                                <td><input type="radio" name="quality" class="radio" value="3"></td>
                                                                <td><input type="radio" name="quality" class="radio" value="4"></td>
                                                                <td><input type="radio" name="quality" class="radio" value="5"></td>
                                                            </tr>
                                                            <tr>
                                                                <td class="cell-label">Price</td>
                                                                <td><input type="radio" name="Price" class="radio" value="1"></td>
                                                                <td><input type="radio" name="Price" class="radio" value="2"></td>
                                                                <td><input type="radio" name="Price" class="radio" value="3"></td>
                                                                <td><input type="radio" name="Price" class="radio" value="4"></td>
                                                                <td><input type="radio" name="Price" class="radio" value="5"></td>
                                                            </tr>
                                                            <tr>
                                                                <td class="cell-label">Value</td>
                                                                <td><input type="radio" name="Value" class="radio" value="1"></td>
                                                                <td><input type="radio" name="Value" class="radio" value="2"></td>
                                                                <td><input type="radio" name="Value" class="radio" value="3"></td>
                                                                <td><input type="radio" name="Value" class="radio" value="4"></td>
                                                                <td><input type="radio" name="Value" class="radio" value="5"></td>
                                                            </tr>
                                                        </tbody>
                                                    </table><!-- /.table .table-bordered -->
                                                </div><!-- /.table-responsive -->
                                            </div><!-- /.review-table -->
                                            
                                            <div class="review-form">
                                                <div class="form-container">
                                                    <form role="form" class="cnt-form">
                                                        
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label for="exampleInputName">Your Name <span class="astk">*</span></label>
                                                                    <input type="text" class="form-control txt" id="exampleInputName" placeholder="">
                                                                </div><!-- /.form-group -->
                                                                <div class="form-group">
                                                                    <label for="exampleInputSummary">Summary <span class="astk">*</span></label>
                                                                    <input type="text" class="form-control txt" id="exampleInputSummary" placeholder="">
                                                                </div><!-- /.form-group -->
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label for="exampleInputReview">Review <span class="astk">*</span></label>
                                                                    <textarea class="form-control txt txt-review" id="exampleInputReview" rows="4" placeholder=""></textarea>
                                                                </div><!-- /.form-group -->
                                                            </div>
                                                        </div><!-- /.row -->
                                                        
                                                        <div class="action text-right">
                                                            <button class="btn btn-primary btn-upper">SUBMIT REVIEW</button>
                                                        </div><!-- /.action -->

                                                    </form><!-- /.cnt-form -->
                                                </div><!-- /.form-container -->
                                            </div><!-- /.review-form -->

                                        </div><!-- /.product-add-review -->                                     
                                        
                                    </div><!-- /.product-tab -->
                                </div><!-- /.tab-pane -->

                            </div><!-- /.tab-content -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.product-tabs -->


            
            </div><!-- /.col -->
            <div class="clearfix"></div>
        </div><!-- /.row -->
 </div><!-- /.container -->
</div><!-- /.body-content -->


    <jsp:include page="footer.jsp"/>
    <jsp:include page="scripts.jsp"/>


</body>
</html>
