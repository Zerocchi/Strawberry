<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Strawberry Cafe - Add or edit menu</title>
</head>
<body>

<%-- Add new invoice/order here --%>

<jsp:include page="userNavBar.jsp" flush="true" />
	<div class="container">
	<div class="jumbotron">
       <h1></h1>
     </div>
	    <form method="POST" action='Order' name="frmAddMenu">
	    <table class="table table-bordered" style="width:40%" align="center">
	        <tr><th colspan="2" style="text-align:center"><span class="glyphicon glyphicon-user"></span> Order</th></tr>
	        <tr>
		        <td>Order ID</td> 
	        	<td>
		        	<input type="text" readonly="readonly" name="orderId" placeholder="Automatically added" 
							value="<c:out value="${order.orderId}" />">
	        	</td>
	        </tr> 
		    <tr>
		        <td>Description</td> 
		        <td><textarea name="description"  class="form-control" rows="5" cols="50"
		            placeholder="Add optional description here"><c:out value="${order.description}"/></textarea>
		        </td>
	        </tr>
	        <c:choose>  
	        <c:when test="${sessionScope.user eq 'admin'}">
	        <tr><td>Name</td><td>${customer.customerName}</td></tr>
	        <tr><td>Phone No</td><td>${customer.customerPhoneNo}</td></tr>
	        <tr><td>E-mail</td><td>${customer.customerEmail}</td></tr>
	        <tr><td>Address</td><td>${customer.customerAddress}</td></tr>
	        <tr>
		        <td>Status</td>
		        <%-- will make this into dropdown box --%> 
		        <td><select name="status" class="form-control">
					<c:choose>  
	        		<c:when test="${order.status eq '0'}">
				  		<option value="0" selected>Incomplete</option>
				  		<option value="1">Complete</option>
				  	</c:when>
				  	<c:otherwise>
				  		<option value="0">Incomplete</option>
				  		<option value="1" selected>Complete</option>
				  	</c:otherwise>
				  	</c:choose>
				  </select>
		        </td>
		    </tr>
		    </c:when>
		    <c:otherwise>
		    <input type="hidden" name="user" value="2">
		    <input type="hidden" name="status" value="0">
		    </c:otherwise>
		    </c:choose>
		 		<tr align="center"><td colspan="2"><input type="submit" class="btn btn-info" value="Submit" />
		 		<a class="btn btn-danger" href="index.jsp">Cancel</a></td>
	 		</tr>
	 	</table>
	    </form>
    </div>
</body>
</html>