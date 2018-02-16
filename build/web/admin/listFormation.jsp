<%-- 
    Document   : style
    Created on : Dec 18, 2017, 7:41:30 PM
    Author     : amine
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/>
<body class="fixed-nav sticky-footer " id="page-top">
	<jsp:include page="navbar.jsp"/>
	<div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
      </ol>

      <div class="row">
      <div class="col-md-6">
        <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Sessions :
          <div class="pull-right">
            <a href="add"><i class="fa fa-plus"></i>Add</a>
          </div>
        </div>
        <div class="card-body">
          
        </div>
      </div>
      </div>
      <div class="col-md-6">
        <div class="card-header">
          <i class="fa fa-table"></i> Categories :
          <div class="pull-right">
            <a href="add"><i class="fa fa-plus"></i>Add</a>
          </div>
        </div>
        <div class="card-body">
          
        </div>
      </div>
      </div>
      </div>
      
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> List de formations :
          	<div class="pull-right">
          	<a href="add"><i class="fa fa-plus"></i>Add</a>
          	</div>
          </div>
        <div class="card-body">
        	<div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>name</th>
                  <th>places available</th>
                  <th>price</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>name</th>
                  <th>places available</th>
                  <th>price</th>
                  <th>Action</th>
                </tr>
              </tfoot>
              <tbody>
              
              	<c:forEach begin="1" end="${formations.size()}" var="i">
	                <tr>
	                  <td>${formations.get(i-1).getNom()}</td>
	                  <td>${formations.get(i-1).getPlaces()}</td>
	                  <td>${formations.get(i-1).getPrice()}</td>
	                  <td><a href="home_admin/${formations.get(i-1).getId()}/edit" class="btn btn-success"><i class="fa fa-edit"></i></a><a href="home_admin/${formations.get(i-1).getId()}/delete" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
	                </tr>
                </c:forEach>
               </tbody>
              </table>
             </div>
            </div>

      </div>

</div>
      

	<jsp:include page="script.jsp"/>
</body>