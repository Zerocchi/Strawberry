<%@ page language="java" 
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
	<th>Menu ID</th>
	<th>Menu Name</th>
	<th>Menu Price</th>
	</tr>
	<c:forEach var="menu" items="${list}">
		<tr>
			<td><c:out value="${menu.menuId}" /></td>
			<td><c:out value="${menu.menuName}" /></td>
			<td><c:out value="${menu.menuPrice}" /></td>
			<td><a href="Menu?action=edit&menuId=<c:out value="${menu.menuId}"/>">Update</a></td>
			<td><a href="Menu?action=delete&menuId=<c:out value="${menu.menuId}"/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<a href="Menu?action=add">Add menu</a>
</body>
</html>