package com.zerocchi.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zerocchi.bean.Menu;
import com.zerocchi.dao.MenuDao;

/**
 * Servlet implementation class MenulistServlet
 */

@WebServlet("/MenulistServlet")
public class MenulistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); 
		
		List<Menu> listMenu = new ArrayList<>();
		//request.getSession().setAttribute("list", dao.getAllMenu());
		listMenu = new MenuDao().getAllMenu();

	    HttpSession session = request.getSession(false);
        if(session!=null){
        	session.setAttribute("food", "food");
    	    session.setAttribute("list", listMenu);
        }
        RequestDispatcher rd=request.getRequestDispatcher("listMenu.jsp");  
		rd.forward(request,response);
		
	}

}
