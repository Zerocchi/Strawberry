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
@WebServlet("/Order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDao orderDAO;
	private UserDao userDAO;
	private static String LIST = "listOrder.jsp";
	private static String ADD_OR_EDIT = "invoices.jsp";
	List<OrderMenu> menus;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        orderDAO = new OrderDao();
        userDAO = new UserDao();
        menus = new ArrayList<>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if(action.equalsIgnoreCase("listOrder")){
			forward = LIST;
			int userId = userDAO.getUserByName((String)session.getAttribute("user")).getUserId();
	        request.setAttribute("orderlist", orderDAO.getAllOrderByUserId(userId));
		} else if(action.equalsIgnoreCase("delete")){
			orderDAO.deleteOrder(Integer.parseInt(request.getParameter("orderId")));
			forward = LIST;
			request.setAttribute("orderlist", orderDAO.getAllOrder());
		} else if(action.equalsIgnoreCase("add")){
			forward = ADD_OR_EDIT;
		} else if(action.equalsIgnoreCase("edit")){
			forward = ADD_OR_EDIT;
			int orderId = Integer.parseInt(request.getParameter("orderId"));
            Order order = orderDAO.getOrderById(orderId);
            request.setAttribute("order", order);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order order = new Order();
		order.setUserId(userDAO.getUserByName((String)session.getAttribute("user")).getUserId());
		order.setDescription(request.getParameter("description"));
		order.setStatus(Integer.parseInt(request.getParameter("status")));
		String orderid = request.getParameter("orderId");
		if(orderid == null || orderid.isEmpty())
			orderDAO.newOrder(order);
		else{
			order.setOrderId(Integer.parseInt(orderid));
			orderDAO.updateOrder(order);
		}
		//RequestDispatcher view = request.getRequestDispatcher(LIST);
		//request.setAttribute("orderlist", orderDAO.getAllOrder());
        //view.forward(request, response);
		response.sendRedirect(request.getContextPath() + "/order.jsp");
	}

}
