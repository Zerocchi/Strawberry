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
import com.zerocchi.bean.Order;
import com.zerocchi.bean.OrderMenu;
import com.zerocchi.dao.MenuDao;
import com.zerocchi.dao.OrderDao;
import com.zerocchi.dao.UserDao;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderMenu")
public class OrderMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDao orderDAO;
	private MenuDao menuDAO;
	private static String LIST = "listOrderMenu.jsp";
	private static String CHECKOUT = "checkout.jsp";
	private static String ADD_OR_EDIT = "ordermenu.jsp";
	List<Menu> menus;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderMenuController() {
        super();
        orderDAO = new OrderDao();
        menuDAO = new MenuDao();
        menus = new ArrayList<>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		HttpSession session = request.getSession();
		
		if (session == null)
		{
		    String address = "index.jsp";
		    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
		    dispatcher.forward(request,response);
		} 
		
		if(action.equalsIgnoreCase("listMenu")){
			forward = LIST;
			request.setAttribute("orderId", orderId);
	        request.setAttribute("menulist", menuDAO.getAllMenuByOrderId(orderId));
			request.setAttribute("allmenulist", menuDAO.getAllMenu());
		} else if(action.equalsIgnoreCase("delete")){
			int menuId = Integer.parseInt(request.getParameter("menuId"));
			menuDAO.deleteMenuFromOrder(orderId, menuId);
			forward = LIST;
			request.setAttribute("orderId", Integer.parseInt(request.getParameter("orderId")));
	        request.setAttribute("menulist", menuDAO.getAllMenuByOrderId(orderId));
			request.setAttribute("allmenulist", menuDAO.getAllMenu());
		} else if(action.equalsIgnoreCase("add")){
			forward = ADD_OR_EDIT;
		} else if(action.equalsIgnoreCase("edit")){
			forward = ADD_OR_EDIT;
            Order order = orderDAO.getOrderById(orderId);
            request.setAttribute("order", order);
		} else if(action.equalsIgnoreCase("checkout")){
			forward = CHECKOUT;
			int orderIdFromRand = orderDAO.getOrderIdByRandomNum((int)session.getAttribute("random"));
			request.setAttribute("totalPrice", orderDAO.getTotalPriceByOrderId(orderIdFromRand));
			request.setAttribute("orderId", orderId);
			session.invalidate();
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Menu menu = new Menu();
		menu.setMenuId(Integer.parseInt(request.getParameter("menuid")));
		menu.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		menuDAO.addMenuToOrder(menu, Integer.parseInt(request.getParameter("orderid")));
		//RequestDispatcher view = request.getRequestDispatcher(LIST);
		//request.setAttribute("orderlist", orderDAO.getAllOrder());
        //view.forward(request, response);
		response.sendRedirect(request.getContextPath() + "/OrderMenu?action=listMenu&orderId=" + request.getParameter("orderid"));
	}

}
