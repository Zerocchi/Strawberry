package com.zerocchi.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zerocchi.bean.Customer;
import com.zerocchi.bean.Order;
import com.zerocchi.dao.UserDao;

/**
 * Servlet implementation class PersonalController
 */
@WebServlet("/Personal")
public class PersonalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PERSONAL_INFO = "personal.jsp";
	private static String NEXT_MENU = "menuPage.jsp";
	private UserDao userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalController() {
        super();
        userDAO = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		session.getAttribute("custid");
		
		if(action.equalsIgnoreCase("add")){
			forward = PERSONAL_INFO;
		} else if(action.equalsIgnoreCase("edit")){
			forward = PERSONAL_INFO;
			int custId = Integer.parseInt(request.getParameter("custId"));
            Customer customer = userDAO.getCustomerById(custId);
            request.setAttribute("customer", customer);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Customer customer = new Customer();
		customer.setCustomerId((int)session.getAttribute("custid"));
		customer.setCustomerName(request.getParameter("custname"));
		customer.setCustomerEmail(request.getParameter("custemail"));
		customer.setCustomerPhoneNo(Integer.parseInt(request.getParameter("custphone")));
		customer.setCustomerAddress(request.getParameter("address"));
		String custid = request.getParameter("custid");
		if(custid == null || custid.isEmpty())
			userDAO.newCustomer(customer);
		else{
			customer.setCustomerId(Integer.parseInt(custid));
			userDAO.updateCustomer(customer);
		}
		//RequestDispatcher view = request.getRequestDispatcher(LIST);
		//request.setAttribute("orderlist", orderDAO.getAllOrder());
        //view.forward(request, response);
		if(session.getAttribute("user").equals("admin"))
			response.sendRedirect(request.getContextPath() + "/order.jsp");
		else
			response.sendRedirect(request.getContextPath() + "/nextStep.jsp");
	}

}
