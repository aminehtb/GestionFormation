<%-- 
    Document   : style
    Created on : Dec 18, 2017, 7:41:30 PM
    Author     : amine
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/>
<body id="page-top">
	
	<div class="content">
    <div class="container">
      
      <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Add Keyword</div>
      <div class="card-body">
        <form method="post">
          
          <div class="form-group">
            <label >description</label>
            <textarea class="form-control" name="description" placeholder="seperate each keyword with comma ," rows="3"></textarea>
          </div>
          <button class="btn btn-primary btn-block" type="submit">next</button>
        </form>
        <div class="text-center">
        </div>
      </div>
    </div>
  </div>
</div>
      

	<jsp:include page="script.jsp"/>
</body>