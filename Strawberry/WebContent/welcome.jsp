<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.zerocchi.connection.ConnectionProvider" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
    <h3>Login successful!!!</h3>
    <h4>
        Hello,
        <%=session.getAttribute("name")%></h4>
    <a href="addMenu.jsp">Add Menu</a> || <a href="updateMenu.jsp">Update Menu</a> || <a href="deleteMenu.jsp">Delete Menu</a>
	
	${ listMenu }
	
	<%-- 
	<table border="1" width="100%">
		<tr>
		<th>Menu ID</th>
		<th>Menu Name</th>
		<th>Menu Price</th>
		</tr>
		<c:forEach var="row" items="${listMenu}">
		<tr>
		<td><c:out value="${row.menu_id}"/></td>
		<td><c:out value="${row.menu_name}"/></td>
		<td><c:out value="${row.menu_price}"/></td>
		</tr>
		</c:forEach>
	</table>
	--%>

</body>
</html>