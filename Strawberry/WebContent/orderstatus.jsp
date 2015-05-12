<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Strawberry Cafe - Order Status</title>
</head>
<body>

<%-- Add new invoice/order here --%>

<jsp:include page="userNavBar.jsp" flush="true" />
	<div class="container">
	<div class="jumbotron">
       <h1></h1>
     </div>
	    <table class="table table-bordered" style="width:40%" align="center">
	        <tr><th colspan="2" style="text-align:center"><span class="glyphicon glyphicon-user"></span>Order Status</th></tr>
	        <tr>
		        <td>Order ID</td> 
	        	<td>${order.orderId}</td>
	        </tr> 
	        <tr>
		        <td>Description</td> 
		        <td>${order.description}</td>
		    </tr>
		    <tr>
		        <td>Status</td> 
		        <td>
		        	<c:choose>  
					<c:when test="${order.status eq '0'}">
					<a class="btn btn-danger" href="#">Incomplete</a>
					</c:when>
					<c:when test="${order.status eq '1'}">
					<a class="btn btn-success" href="#">Complete</a>
					</c:when>
					</c:choose>
		        </td>
	        </tr>
	        <tr>
		 		<td colspan="2" align="center"><a class="btn btn-default" href="order.jsp">Back to Order Menu</a></td>
	 		</tr>
	 	</table>
    </div>
</body>
</html>