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
          <i class="fa fa-table"></i> List des inscrit :
          </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>first name</th>
                  <th>last name</th>
                  <th>phone</th>
                  <th>adress</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>first name</th>
                  <th>last name</th>
                  <th>phone</th>
                  <th>adress</th>
                </tr>
              </tfoot>
              <tbody>
              
                <c:forEach begin="1" end="${users.size()}" var="i">
                  <tr>
                    <td>${users.get(i-1).getFirstname()}</td>
                    <td>${users.get(i-1).getLastname()}</td>
                    <td>${users.get(i-1).getPhone()}</td>
                    <td>${users.get(i-1).getAdress()}</td>
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