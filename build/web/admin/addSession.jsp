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
            <div class="card-header">Add Session</div>
            <div class="card-body">
              <form method="post">
                <input type="hidden" name="location" value="formation">
                <div class="form-group">
                  <div class="form-row">
                    <div class="col-md-6">
                      <label >name</label>
                      <input class="form-control" type="text" placeholder="Enter name" name="name">
                    </div>
                    <div class="col-md-6">
                      <label>date debut </label>
                      <input class="form-control date" type="text"  id="datepicker" placeholder="click to add date" name="date">
                    </div>
                  </div>
                </div>
                
                <button class="btn btn-primary btn-block" type="submit">next</button>
              </form>
              <div class="text-center">
              </div>
            </div>
          </div>
       
      </div>
    </div>
  </div>
</div>
      

	<jsp:include page="script.jsp"/>
	 <script type="text/javascript">
            $(function () {
                $('#datepicker').datepicker({
      autoclose: true,
      format: 'yyyy-mm-dd',
      endDate:"0", 
    });
            });
</script>
</body>