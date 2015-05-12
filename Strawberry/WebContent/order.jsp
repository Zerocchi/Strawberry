<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin panel</title>
</head>
<body>
<c:choose>  
<c:when test="${sessionScope.user eq 'user' or sessionScope.user eq 'admin'}"> <%-- check if user session is equal to user or admin --%>
<jsp:forward page="/Order?action=listOrder" />
</c:when>  
<c:otherwise>
<jsp:forward page="user.jsp" />
</c:otherwise>
</c:choose>
</body>
</html>