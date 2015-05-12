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
<c:when test="${sessionScope.user eq 'user'}"> <%-- check if user session is equal to user --%>    
<jsp:include page="userNavBar.jsp" flush="true" />

<div class="container">

     <!-- Main component for a primary marketing message or call to action -->
     <div class="jumbotron">
       <h1></h1>
     </div>
     
     Order ID: <c:out value="${orderId}"/>
     <form action="OrderMenu" method="post">
     	<input type="hidden" name="orderid" value=<c:out value="${orderId}"/>>
		<table class="table table-hover">
				<tr>
				<th>Menu Name</th>
				<th>Menu Price</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Action</th>
				</tr>
				<c:forEach var="menu" items="${menulist}">
	        		<c:if test="${empty menu}">
		        		<tr>
		        		<td colspan="4"><p align="center">There is no menu yet. Consider adding one.</p></td>
		        		</tr>
	        		</c:if>
	        		<tr>
					<td>${menu.menuName}</td>
					<td>${menu.menuPrice}</td>
					<td>${menu.quantity}</td>
					<td>${menu.menuPrice * menu.quantity}</td>
					<td><a class="btn btn-sm btn-danger" href="OrderMenu?action=delete&orderId=${orderId}&menuId=${menu.menuId}">Delete Menu</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2">
						<select name="menuid" class="form-control">
						<c:forEach var="allmenu" items="${allmenulist}">
				  				<option value="${allmenu.menuId}">${allmenu.menuName} (RM${allmenu.menuPrice})</option>			  			
						</c:forEach>
						</select>
					</td>
					<td><input type="number" class="form-control" name="quantity" min="1" max="50" step="1" value="1"></td>
					<td></td>
					<td><input type="submit" class="btn btn-sm btn-primary" value="Add Menu"></td>
		</table>
		</form>
		<p align="center"><a class="btn btn-dm btn-default" href="order.jsp">Back to Order Page</a></p>
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