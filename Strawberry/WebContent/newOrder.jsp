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

     <form method="POST" action="Order" id="addform">
     
     <table class="table table-hover">
		<tr>
		<td>
			<select name="menuName">
		    	<c:forEach var="item" items="${list}">
		     	<option value="${item.menuName}">${item.menuName}</option>
		    	</c:forEach>
			</select>
		</td>
		<td><input type="number" name="quantity" min="1" max="50"></td>
		<td>b</td>
		<td><input type="submit" class="btn btn-sm btn-primary" value="Add"></td>
		</tr>

		</table>
	</form>

</c:when>  
<c:otherwise>
<jsp:forward page="admincp.jsp" />
</c:otherwise>
</c:choose>
</body>
</html>