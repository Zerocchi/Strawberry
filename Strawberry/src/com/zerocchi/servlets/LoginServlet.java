
package com.zerocchi.servlets;  

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zerocchi.dao.LoginDao; 

/**
 * Login Servlet
 * @author zerocchi
 * The logged username will be stored in "name" attribute for current session.
 * Planned to get the user_type from database instead. Need to edit LoginDao
 * validate() method to return user_type (if user_type found) instead of boolean.
 */

public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        
        if(LoginDao.validate(n, p) && n.equals("admin")){  
        	HttpSession session = request.getSession(false);
            if(session!=null)
            	session.setAttribute("user", n); // set session attribute of user name
    		response.sendRedirect("admin.jsp");
        } else if(LoginDao.validate(n, p) && !n.equals("admin")) {
        	HttpSession session = request.getSession(false);
            if(session!=null)
             	session.setAttribute("user", n);
        	response.sendRedirect("user.jsp");
        } else {  
            RequestDispatcher rd=request.getRequestDispatcher("admincp.jsp");  
            rd.forward(request,response);  
        }  

        out.close();  
    }  
} 