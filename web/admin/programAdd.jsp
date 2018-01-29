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

      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> List de formations :
          	<div class="pull-right">
          	<a href="add"><i class="af fa-"></i>Add</a>
          	</div>
          </div>
        <div class="card-body">
        	<div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>nom</th>
                  <th>tache</th>
                  <th>du</th>
                  <th>au</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <<th>nom</th>
                  <th>tache</th>
                  <th>du</th>
                  <th>au</th>
                  <th>Action</th>
                </tr>
              </tfoot>
              <tbody>
              <tr>
                <form >
                    <td>
                    <div class="form-group">
                          <input class="form-control" type="text" placeholder="nom" name="nom">
                    </div>
                    </td>
                    <td>
                    <div class="form-group">
                          <input class="form-control" type="text" placeholder="tache" name="tache">
                    </div>
                    </td>
                    <td>
                    <div class="form-group">
                          <input class="form-control" type="text" placeholder="tache" name="du">
                    </div>
                    </td>
                    <td>
                    <div class="form-group">
                          <input class="form-control" type="text" placeholder="tache" name="du">
                    </div>
                    </td>
                    <td>
                    <button class="btn -btn-default" type="submit">Add</button>
                    </td>
                </form>
                  
              </tr>
              
              	<c:forEach begin="1" end="${programs.size()}" var="i">
	                <tr>
	                  <td>${programs.get(i-1).getNom()}</td>
	                  <td>${programs.get(i-1).getTache()}</td>
	                  <td>${programs.get(i-1).getDu()}</td>
                    <td>${programs.get(i-1).getAu()}</td>
	                  <td><a href="home_admin/${programs.get(i-1).getId()}/edit" class="btn btn-success"><i class="fa fa-edit"></i></a><a href="home_admin/${programs.get(i-1).getId()}/delete" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
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