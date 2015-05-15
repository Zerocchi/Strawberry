<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Strawberry Cafe - Add or edit menu</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="adminNavBar.jsp" flush="true" />
	<div class="container">
	<div class="jumbotron">
       <h1></h1>
     </div>
	    <form method="POST" action='Menu' name="frmAddMenu">
	    <table class="table table-bordered" style="width:40%" align="center">
	        <tr><th colspan="2" style="text-align:center"><span class="glyphicon glyphicon-user"></span> Add/Edit Menu</th></tr>
	        <tr>
		        <td>Menu ID</td> 
	        	<td>
		        	<input type="text" readonly="readonly" name="menuId" placeholder="Automatically added"
		            	value="<c:out value="${menu.menuId}" />">
	        	</td>
	        </tr> 
	        <tr>
		        <td>Menu Name</td> 
		        <td><input type="text" name="menuName"
		            value="<c:out value="${menu.menuName}" />" />
		        </td>
	        </tr> 
	        <tr>
		        <td>Menu Price</td>
		        <td> <input type="text" name="menuPrice"
		            value="<c:out value="${menu.menuPrice}" />" />
		        </td>
		    </tr> 
		 		<tr align="center"><td colspan="2"><input type="submit" class="btn btn-info" value="Submit" />
		 		<a class="btn btn-danger" href="/Strawberry/admin.jsp">Cancel</a></td>
	 		</tr>
	 	</table>
	    </form>
    </div>
</body>
</html>