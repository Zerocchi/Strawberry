<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Strawberry Cafe - Order Status</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%-- Add new invoice/order here --%>




	<div class="container">
	<div class="jumbotron">
       <h1></h1>
     </div>
	    <table class="table table-bordered" style="width:40%" align="center">
	        <tr><th colspan="2" style="text-align:center"><span class="glyphicon glyphicon-user"></span>Order Status</th></tr>
	        <tr>
		        <td>Order ID</td> 
		        <c:choose>  
				<c:when test="${order.orderId eq 0}"> <%-- check if user session is equal to user --%>    
				<td>This order ID doesn't exist!</td>
				</c:when>  
				<c:otherwise>
				<td>${order.orderId}</td>
				</c:otherwise>
				</c:choose>   	
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
		 		<td colspan="2" align="center"><a class="btn btn-default" href="index.jsp">Back to Main Page</a></td>
	 		</tr>
	 	</table>
    </div>
</body>
</html>