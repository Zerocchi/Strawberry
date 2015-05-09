<%@ page language="java" 
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Strawberry Café - Order Panel</title>
</head>
<body>
<c:choose>  
<c:when test="${sessionScope.user eq 'user'}"> <%-- check if user session is equal to admin --%>    
<jsp:include page="userNavBar.jsp" flush="true" />

<div class="container">

     <!-- Main component for a primary marketing message or call to action -->
     <div class="jumbotron">
       <h1></h1>
     </div>
		<table class="table table-hover">
				<tr>
				<th>Order Information</th>
				<th>Action</th>
				</tr>
				<c:forEach var="order" items="${orderlist}">
					<tr>
					<td>${order.orderId} and ${order.userId}</td>
					<td><a class="btn btn-sm btn-primary" href="Menu?action=add&orderId=<c:out value="${order.orderId}"/>">Add Menu</a>
					<a class="btn btn-sm btn-primary" href="Order?action=edit&orderId=<c:out value="${order.orderId}"/>">Update Invoice</a>
					<a class="btn btn-sm btn-danger" href="Order?action=delete&orderId=<c:out value="${order.orderId}"/>">Delete Invoice</a></td>
					</tr>
				</c:forEach>
		</table>
		<p align="right"><a class="btn btn-dm btn-primary" href="Order?action=add">Add Invoice</a></p>
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