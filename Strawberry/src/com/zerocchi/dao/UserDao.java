package com.zerocchi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zerocchi.bean.Customer;
import com.zerocchi.bean.Order;
import com.zerocchi.bean.User;
import com.zerocchi.connection.ConnectionProvider;

public class UserDao {

	private Connection con;
	private static int STATUS = 0;
	
	public User getUserByName(String name) {
		if(con == null)
			con = ConnectionProvider.getCon();
		User user = new User();
		try {
			PreparedStatement ps = con.prepareStatement("select * from users where user_name = ? ");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				user.setUserId(rs.getInt("user_id"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int newCustomer(Customer c) {
		
		try {
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("insert into customers (customer_id, cust_name, cust_address, cust_email, cust_phoneno) "
					+ "values (?, ?, ?, ?, ?)");  
			ps.setInt(1,c.getCustomerId());
			ps.setString(2, c.getCustomerName());
			ps.setString(3, c.getCustomerAddress());
			ps.setString(4, c.getCustomerEmail());
			ps.setInt(5, c.getCustomerPhoneNo());
			              
			STATUS = ps.executeUpdate();
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return STATUS;
		
	}

	public int updateCustomer(Customer c) {
		try {  
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("update customers set cust_name=?, cust_phoneno=?, cust_address=?, cust_email=? where customer_id = ?");
			ps.setString(1,c.getCustomerName());
			ps.setInt(2, c.getCustomerPhoneNo());
			ps.setString(3, c.getCustomerAddress());
			ps.setString(4, c.getCustomerEmail());

			STATUS=ps.executeUpdate();  
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		return STATUS;
		
	}

	public Customer getCustomerById(int customerId) {
		if(con == null)
			con = ConnectionProvider.getCon();
		Customer customer = new Customer();
		try {
			PreparedStatement ps = con.prepareStatement("select distinct * from customers"
					+ " where customer_id = ? ");
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerName(rs.getString("cust_name"));
				customer.setCustomerPhoneNo(rs.getInt("cust_phoneno"));
				customer.setCustomerEmail(rs.getString("cust_email"));
				customer.setCustomerAddress(rs.getString("cust_address"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public int getCustomerNameLengthInOrder(int orderId) {
		
		int count = 0;
		
		try {  
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("select length(c.cust_name) as total from orders o, customers c "
					+ "where o.customer_id = c.customer_id and o.order_id = ?");
			ps.setInt(1,orderId);

			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("total");
			}
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		return count;
	}
	
	public Customer getCustomerDetails(int orderId) {
		
		int count = 0;
		Customer customer = new Customer();
		
		try {  
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("select c.cust_name as name, c.cust_address as addr, c.cust_phoneno as phone, c.cust_email"
					+ " as mail from orders o, customers c where o.customer_id = c.customer_id and o.order_id = ?");
			ps.setInt(1,orderId);

			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				customer.setCustomerName(rs.getString("name"));
				customer.setCustomerAddress(rs.getString("addr"));
				customer.setCustomerPhoneNo(rs.getInt("phone"));
				customer.setCustomerEmail(rs.getString("mail"));
			}
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		return customer;
	}

	public int deleteUserInfoInOrder(int orderId) {
		
		try {    
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("delete from customers where customer_id = "
					+ "(select customer_id from orders where order_id = ?)");
			ps.setInt(1,orderId);     
			              
			STATUS=ps.executeUpdate(); 
			
		}catch(Exception e){
				e.printStackTrace();
		}    
		
		return STATUS;
		
	}
}
