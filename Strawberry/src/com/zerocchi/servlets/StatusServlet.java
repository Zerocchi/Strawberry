package com.zerocchi.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerocchi.bean.Order;
import com.zerocchi.dao.OrderDao;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/Status")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDao orderDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        orderDAO = new OrderDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward;
		forward = "orderstatus.jsp";
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		Order order = orderDAO.getOrderById(orderId);
		request.setAttribute("order", order);
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
