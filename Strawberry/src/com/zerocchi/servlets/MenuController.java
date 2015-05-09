package com.zerocchi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation of menu controller
 */
@WebServlet("/Menu")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDao dao;
	private static String INSERT_OR_EDIT = "/menu.jsp";
    private static String LIST = "/listMenu.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
        super();
        dao = new MenuDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		if (session == null)
		{
		    String address = "index.jsp";
		    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
		    dispatcher.forward(request,response);
		} 
		
		if(action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int menuId = Integer.parseInt(request.getParameter("menuId"));
            Menu menu = dao.getMenuById(menuId);
            request.setAttribute("menu", menu);
		} else if(action.equalsIgnoreCase("delete")) {
			int menuId = Integer.parseInt(request.getParameter("menuId"));
			dao.deleteMenu(menuId);
			forward = LIST;
			request.setAttribute("list", dao.getAllMenu());
		} else if(action.equalsIgnoreCase("listMenu")) {
			forward = LIST;
	        request.setAttribute("list", dao.getAllMenu());
		} else if(action.equalsIgnoreCase("add")) {
			forward = INSERT_OR_EDIT;
		}
		
		//request.setAttribute("list", dao.getAllMenu());
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Menu menu = new Menu();
		menu.setMenuName(request.getParameter("menuName"));
		menu.setMenuPrice(Double.parseDouble(request.getParameter("menuPrice")));
		String menuid = request.getParameter("menuId");
		if(menuid == null || menuid.isEmpty())
        {
            dao.addMenu(menu);
        }
        else
        {
            menu.setMenuId(Integer.parseInt(menuid));
            dao.updateMenu(menu);
        }
		RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("list", dao.getAllMenu());
        view.forward(request, response);
	}

}
