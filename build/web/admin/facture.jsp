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
          <a href="adminHome">Dashboard</a>
        </li>
      </ol>

   
 </div>
 <div class="container">
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> List des facture :
          </div>
        <div class="card-body">
        	<form method="GET" action="listfacture">
        		<div class="form-row">
        			<div class="col-md-6">
        				<label>users</label>
	                    <select class="form-control" name="user_i" >
	                    	<option selected>select user</option>	
	                      <c:forEach begin="1" end="${users.size()}" var="i">
	                        <option value="${users.get(i-1).getId()}">${users.get(i-1).getFirstname()}</option>
	                      </c:forEach>
	                    </select>
        			</div>
        			<div class="col-md-6">
        				<label>formation</label>
	                    <select class="form-control" name="formation_i" >
	                    	<option selected>select formation</option>
	                      <c:forEach begin="1" end="${formations.size()}" var="i">
	                        <option value="${formations.get(i-1).getId()}">${formations.get(i-1).getNom()}</option>
	                      </c:forEach>
	                    </select>
        			</div>
        		</div>
        		<hr>
        		<input type="submit" class="btn btn-primary btn-block" value="filter" name="filter">
        	</form>
        	<hr>
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>first name</th>
                  <th>formation</th>
                  <th>price</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>first name</th>
                  <th>formation</th>
                  <th>price</th>
                </tr>
              </tfoot>
              <tbody>
              
                <c:forEach begin="1" end="${factures.size()}" var="i">
                  <tr>
                    <td>${nom[i-1]}</td>
                    <td>${formation[i-1]}</td>
                    <td>${factures.get(i-1).getMontant()}</td>
                  </tr>
                </c:forEach>
               </tbody>
              </table>
             </div>
            </div>

      </div>
      </div>

</div>
      

  <jsp:include page="script.jsp"/>
</body>