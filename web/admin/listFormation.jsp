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
    <div class="container">
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> List de formations :
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
	                  <td>
                    <a href="rapport?fid=${formations.get(i-1).getId()}">
                      ${formations.get(i-1).getNom()}
                    </a>
                    </td>
	                  <td>${formations.get(i-1).getPlaces()}</td>
	                  <td>${formations.get(i-1).getPrice()}</td>
	                  <td><a href="adminHome?type=for&id=${formations.get(i-1).getId()}&action=edit" class="btn btn-default"><i class="fa fa-edit"></i></a><a href="adminHome?type=for&id=${formations.get(i-1).getId()}&action=delete" class="btn btn-default"><i class="fa fa-remove"></i></a></td>
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