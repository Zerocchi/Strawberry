<%@ page language="java" 
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<title>Strawberry Café - Order Panel</title>
</head>
<body>
<c:choose>  
<c:when test="${sessionScope.user eq 'user'}"> <%-- check if user session is equal to user --%>    
<jsp:include page="userNavBar.jsp" flush="true" />
</c:when>  
<c:otherwise>
<jsp:include page="adminNavBar.jsp" flush="true" />
</c:otherwise>
</c:choose>

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
	        		<c:set var="menuPrice"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${menu.menuPrice}" /></c:set>
	        		<c:set var="menuTotal"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${menu.menuPrice * menu.quantity}" /></c:set>
					<td>${menu.menuName}</td>
					<td>RM${menuPrice}</td>
					<td>${menu.quantity}</td>
					<td>RM${menuTotal}</td>
					<td><a class="btn btn-sm btn-danger" href="OrderMenu?action=delete&orderId=${orderId}&menuId=${menu.menuId}">Delete Menu</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2">
						<select name="menuid" class="form-control">
						<c:forEach var="allmenu" items="${allmenulist}">
								<c:set var="allMenuPrice"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${allmenu.menuPrice}" /></c:set>
				  				<option value="${allmenu.menuId}">${allmenu.menuName} (RM${allMenuPrice})</option>			  			
						</c:forEach>
						</select>
					</td>
					<td><input type="number" class="form-control" name="quantity" min="1" max="50" step="1" value="1"></td>
					<td></td>
					<td><input type="submit" class="btn btn-sm btn-primary" value="Add Menu"></td>
		</table>
		</form>
		<c:choose>  
		<c:when test="${sessionScope.user eq 'user'}"> <%-- check if user session is equal to user --%>    
		<p align="center"><a class="btn btn-dm btn-success" href="OrderMenu?action=checkout&orderId=${orderId}">Checkout</a></p>
		</c:when>  
		<c:otherwise>
		<p align="center"><a class="btn btn-dm btn-primary" href="order.jsp">Back to Order List</a></p>
		</c:otherwise>
		</c:choose>
		
	</div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>