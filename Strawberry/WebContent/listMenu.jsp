<%@ page language="java" 
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Strawberry Café - Admin Panel</title>
</head>
<body>
<c:choose>  
<c:when test="${sessionScope.user eq 'admin'}"> <%-- check if user session is equal to admin --%>    
<jsp:include page="adminNavBar.jsp" flush="true" />

   <div class="container">

     <!-- Main component for a primary marketing message or call to action -->
     <div class="jumbotron">
       <h1></h1>
     </div>
     <table class="table table-hover">
		<tr>
		<th>Menu ID</th>
		<th>Menu Name</th>
		<th>Menu Price</th>
		<th>Actions</th>
		</tr>
		<c:forEach var="menu" items="${list}">
			<tr>
				<c:set var="menuPrice"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${menu.menuPrice}" /></c:set>
				<td><c:out value="${menu.menuId}" /></td>
				<td><c:out value="${menu.menuName}" /></td>
				<td>RM<c:out value="${menuPrice}" /></td>
				<td><a class="btn btn-sm btn-primary" href="Menu?action=edit&menuId=<c:out value="${menu.menuId}"/>">Update</a>
				<a class="btn btn-sm btn-danger" href="Menu?action=delete&menuId=<c:out value="${menu.menuId}"/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p align="right"><a class="btn btn-dm btn-primary" href="Menu?action=add"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Add Menu</a></p>
   </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</c:when>  
<c:otherwise>
<jsp:forward page="admincp.jsp" />
</c:otherwise>
</c:choose>
</body>
</html>