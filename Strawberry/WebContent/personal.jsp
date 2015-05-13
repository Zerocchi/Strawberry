<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Strawberry Cafe - Personal Information</title>
</head>
<body>

<%-- Add new invoice/order here --%>

<jsp:include page="userNavBar.jsp" flush="true" />
	<div class="container">
	<div class="jumbotron">
       <h1></h1>
     </div>
	    <form method="POST" action='Personal' name="frmAddMenu">
	    <table class="table table-bordered" style="width:40%" align="center">
	        <tr><th colspan="2" style="text-align:center"><span class="glyphicon glyphicon-user"></span> Personal Information</th></tr>
	        <tr>
		        <td>Name</td> 
	        	<td>
		        	<input type="text" name="custname" size="38" placeholder="Example: John Doe" 
							value="<c:out value="${customer.customerName}" />" required>
	        	</td>
	        </tr> 
	        <tr>
		        <td>Email</td> 
	        	<td>
		        	<input type="text" name="custemail" size="38" placeholder="Example: johndoe@email.com" 
							value="<c:out value="${customer.customerEmail}" />">
	        	</td>
	        </tr>
	        <tr>
		    	<td>Phone Number</td> 
		        <td><input type="text" name="custphone" size="38"
		            placeholder="Enter your phone number without (-)" value="<c:out value="${customer.customerPhoneNo}" />"/>
		        </td>
		    </tr>
		    <tr>
		        <td>Address</td> 
		        <td><textarea name="address"  class="form-control" rows="5" cols="50"
		            placeholder="Enter your address"><c:out value="${customer.customerAddress}"/></textarea>
		        </td>
	        </tr>
		 		<tr align="center"><td colspan="2"><input type="submit" class="btn btn-info" value="Submit" />
		 		<a class="btn btn-danger" href="order.jsp">Cancel</a></td>
	 		</tr>
	 	</table>
	    </form>
    </div>
</body>
</html>