<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Add new menu</title>
</head>
<body>

    <form method="POST" action='Menu' name="frmAddMenu">
        Menu ID : <input type="text" readonly="readonly" name="menuId"
            value="<c:out value="${menu.menuId}" />" /><br /> 
        Menu Name : <input
            type="text" name="menuName"
            value="<c:out value="${menu.menuName}" />" /> <br /> 
        Menu Price : <input
            type="text" name="menuPrice"
            value="<c:out value="${menu.menuPrice}" />" /> <br /> 
 			<input type="submit" value="Submit" />
    </form>
</body>
</html>