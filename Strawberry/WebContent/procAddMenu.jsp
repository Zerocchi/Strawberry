<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@page import="com.zerocchi.dao.MenuDao"%>  
    <jsp:useBean id="menu" class="com.zerocchi.bean.Menu"/>  
      
    <jsp:setProperty property="*" name="menu"/>  
    
    <jsp:scriptlet>
    int status=MenuDao.addMenu(menu);  
    if(status>0) {
    	out.print("Menu has been successfully added.");
    	request.getRequestDispatcher("addMenu.jsp").include(request, response);
    }
    </jsp:scriptlet>
    
    
</body>
</html>