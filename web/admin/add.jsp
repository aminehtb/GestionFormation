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
      <c:choose >
        <c:when test="${empty place}" >
          <div class="card card-register mx-auto mt-5">
            <div class="card-header">Add formation</div>
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
                      <label>price </label>
                      <input class="form-control" type="text"  placeholder="Enter price" name="price">
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label >description</label>
                  <textarea class="form-control" name="description" placeholder="Enter description" rows="3"></textarea>
                </div>  
                <div class="form-group">
                  <div class="form-row">
                    <div class="col-md-6"> 
                      <label >Number of places</label>
                      <input class="form-control"  type="text" placeholder="places" name="places">
                    </div>
                    <div class="col-md-6">
                      <label >Number of hours</label>
                      <input class="form-control" type="text" placeholder="hours" name="hours">
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <div class="form-row">
                    <div class="col-md-6">
                      <label  >category</label>
                      <select class="form-control" name="category">
                        <c:forEach begin="1" end="${categories.size()}" var="i">
                          <option value="${categories.get(i-1).getId()}">${categories.get(i-1).getNom()}</option>
                        </c:forEach>
                      </select>
                    </div>
                    <div class="col-md-6">
                      <label>niveau</label>
                      <select class="form-control" name="niveau">
                        <c:forEach begin="1" end="${niveaus.size()}" var="i">
                          <option value="${niveaus.get(i-1).getId()}">${niveaus.get(i-1).getNom()}</option>
                        </c:forEach>
                      </select>
                    </div>
                    
                  </div>
                </div>
                <div class="form-group">
                    <label>session</label>
                    <select class="form-control" name="session" multiple="true" required>
                      <c:forEach begin="1" end="${sessions.size()}" var="i">
                        <option value="${sessions.get(i-1).getId()}">${sessions.get(i-1).getNom()}</option>
                      </c:forEach>
                    </select>
                    
                  <p class="help-block">Hold Ctrl ( or Comande on Mac ) to select multiple.</p>
                </div>
                <button class="btn btn-primary btn-block" type="submit">next</button>
              </form>
              <div class="text-center">
              </div>
            </div>
          </div>
        </c:when>
        <c:when test="${place=='program'}" >
        <div class="card card-register mx-auto mt-5">
            <div class="card-header">
              List de Program :
              <div class="pull-right">
              <form method="POST">
                <input type="hidden" name="location" value="program">
                <input type="hidden" name="submit" value="all">
                <button class="btn btn-success" type="submit">submit</button>
              </form>
                
              </div>
            </div>
            <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" width="100%" cellspacing="0">
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
                      <th>nom</th>
                      <th>tache</th>
                      <th>du</th>
                      <th>au</th>
                      <th>Action</th>
                    </tr>
                  </tfoot>
                  <tbody>
                  <tr>
                    <form method="POST">
                      <input type="hidden" name="submit" value="single">
                      <input type="hidden" name="location" value="program">
                      <input type="hidden" name="formation_id" value="${formation_id}">
                      
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
                              <input class="form-control  datetimepicker-input datetimepicker" type="text" placeholder="du" name="du">
                        </div>
                        </td>
                        <td>
                        <div class="form-group">
                              <input class="form-control datetimepicker-input datetimepicker" type="text" placeholder="au" name="au">
                        </div>
                        </td>
                        <td>
                        <button class="btn -btn-default" type="submit">Add</button>
                        </td>
                    </form>
                      
                  </tr>
                  
                    <c:forEach begin="1" end="${programs.size()}" var="i">
                      <tr>
                        <td>${programs.get(i-1).getTitre()}</td>
                        <td>${programs.get(i-1).getTache()}</td>
                        <td>${programs.get(i-1).getDu()}</td>
                        <td>${programs.get(i-1).getAu()}</td>
                        <td>
                          <a href="home_admin/${programs.get(i-1).getId()}/edit" class="btn btn-success">
                          <i class="fa fa-edit"></i>
                          </a>
                          <a href="home_admin/${programs.get(i-1).getId()}/delete" class="btn btn-danger">
                          <i class="fa fa-remove"></i>
                          </a>
                        </td>


                      </tr>
                    </c:forEach>
                   </tbody>
                  </table>
                 </div>
                </div>
        </div>
        </c:when>
        <c:when test="${place=='keyword'}" >
        <div class="card card-register mx-auto mt-5">
          <div class="card-header">Add Keyword</div>
          <div class="card-body">
            <form method="post">
              <input type="hidden" name="location" value="keyword">
              
              <div class="form-group">
                <div class="form-row">
                  <div class="col-md-8">
                    <input type="text" class="form-control" name="new_key" placeholder="add new keyword">   <hr>                
                  </div>

                  <div class="col-md-4">
                    <input name="action" class="btn btn-primary btn-block" type="submit" value="add keyword">
                  </div>

                </div>
                <div class="form-row">

                    <select class="form-control" name="keywords" multiple="true">
                      <c:forEach begin="1" end="${keywords.size()}" var="i">
                        <option value="${keywords.get(i-1).getId()}">${keywords.get(i-1).getMot()}</option>
                      </c:forEach>
                    </select>

                </div>
                <p class="help-block">Hold Ctrl ( or Comande on Mac ) to select multiple.</p>
              </div>
              <input class="btn btn-primary btn-block" name="action" type="submit" value="next"/>
            </form>
            <div class="text-center">
            </div>
          </div>
        </div>
        </c:when>
      </c:choose>
      </div>
    </div>
  </div>
</div>
      

	<jsp:include page="script.jsp"/>

  
<!--   <script type="text/javascript">
    $(function () {

      $(".datetimepicker").datepicker();

    });
  </script> -->
</body>