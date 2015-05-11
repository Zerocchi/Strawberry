<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
	        <tr><th colspan="2" style="text-align:center"><span class="glyphicon glyphicon-user"></span> Add Invoices</th></tr>
	        <tr>
		        <td>Order ID</td> 
	        	<td>
		        	<input type="text" readonly="readonly" name="orderId" placeholder="Automatically added" 
							value="<c:out value="${order.orderId}" />">
	        	</td>
	        </tr> 
	        <tr>
		        <td>User</td> 
		        <td><input type="text" name="user" readonly="readonly"
		            placeholder="<c:out value="${sessionScope.user}" />" value="<c:out value="${order.userId}" />"/>
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
	        <tr>
		        <td>Status</td>
		        <%-- will make this into dropdown box --%> 
		        <td><select name="status">
				  <option value="0" selected>Incomplete</option>
				  <option value="1">Complete</option>
				  </select>
		        </td>
		    </tr>
		    </c:when>
		    <c:otherwise>
		    <input type="hidden" name="status" value="0">
		    </c:otherwise>
		    </c:choose>
		 		<tr align="center"><td colspan="2"><input type="submit" class="btn btn-info" value="Submit" />
		 		<a class="btn btn-danger" href="order.jsp">Cancel</a></td>
	 		</tr>
	 	</table>
	    </form>
    </div>
</body>
</html>