package com.zerocchi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zerocchi.bean.Menu;
import com.zerocchi.bean.Order;
import com.zerocchi.connection.ConnectionProvider;

public class OrderDao {
	
	/**
	 * Order Data Access Object.
	 * Control the order database flow.
	 */
	 
	private static int STATUS=0;
	private Connection con;
	
	public int newOrder(Order o){  
		  
		try {
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("insert into orders (order_id, user_id, description, status, customer_id) "
					+ "values (order_seq.nextval, ?, ?, 0, ?)");  
			ps.setInt(1,o.getUserId());
			ps.setString(2, o.getDescription());
			ps.setInt(3, o.getCustomerId());
			              
			STATUS = ps.executeUpdate();
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return STATUS;
	}
	
	public int deleteOrder(int orderId){
		
		try {    
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("delete from orders where order_id = ?");
			ps.setInt(1,orderId);     
			              
			STATUS=ps.executeUpdate(); 
			
		}catch(Exception e){
				e.printStackTrace();
		}    
		
		return STATUS;
	}
	
	public int getCurrentOrderId(){
		int currentOrderId = 0;
		try {
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("select order_seq.currval from orders"); 
			ResultSet rs = ps.executeQuery();
			currentOrderId = rs.getInt("order_seq.currval");
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return currentOrderId;
	}
	
	public Order getOrderById(int orderId) {
		if(con == null)
			con = ConnectionProvider.getCon();
		Order order = new Order();
		try {
			PreparedStatement ps = con.prepareStatement("select distinct * from orders"
					+ " where order_id = ? ");
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				order.setOrderId(rs.getInt("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setDescription(rs.getString("description"));
				order.setStatus(rs.getInt("status"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public Order getOrderByCustomerId(int customerId) {
		if(con == null)
			con = ConnectionProvider.getCon();
		Order order = new Order();
		try {
			PreparedStatement ps = con.prepareStatement("select distinct * from orders"
					+ " where customer_id = ? ");
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				order.setOrderId(rs.getInt("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setDescription(rs.getString("description"));
				order.setStatus(rs.getInt("status"));
				order.setCustomerId(rs.getInt("customer_id"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public List<Order> getAllOrder() {
		if(con == null)
			con = ConnectionProvider.getCon();
		List<Order> orders = new ArrayList<>();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from orders order by order_id");
			
			while(rs.next()){
				Order order = new Order();
				order.setOrderId(rs.getInt("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setDescription(rs.getString("description"));
				order.setStatus(rs.getInt("status"));
				orders.add(order);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public List<Order> getAllOrderByUserId(int userId) {
		if(con == null)
			con = ConnectionProvider.getCon();
		List<Order> orders = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select o.order_id as order_id, o.user_id as user_id, o.description"
					+ " as descr, o.status as status from orders o, users u where u.user_id = o.user_id and u.user_id = ?");
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Order order = new Order();
				order.setOrderId(rs.getInt("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setDescription(rs.getString("descr"));
				order.setStatus(rs.getInt("status"));
				orders.add(order);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public int updateOrder(Order o){
		try {  
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("update orders set user_id=?, description=?, status=? where order_id = ?");
			ps.setInt(1,o.getUserId());
			ps.setString(2,o.getDescription());
			ps.setInt(3, o.getStatus());
			ps.setInt(4, o.getOrderId());

			STATUS=ps.executeUpdate();  
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		return STATUS; 
	}

	public int getTotalMenuInOrder(int orderId) {
		
		int count = 0;
		
		try {  
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("select count(menu_id) as total from ordermenu where order_id = ?");
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

	public int deleteAllMenuInOrder(int orderId) {
		
		try {    
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("delete from ordermenu where order_id = ?");
			ps.setInt(1,orderId);     
			              
			STATUS=ps.executeUpdate(); 
			
		}catch(Exception e){
				e.printStackTrace();
		}    
		
		return STATUS;
	}

	public double getTotalPriceByCustomerId(int customerId) {
		
		int totalPrice = 0;
		
		if(con == null)
			con = ConnectionProvider.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("select sum(m.menu_price * om.quantity) as total from ordermenu om, "
					+ "orders o, menu m where om.order_id = o.order_id and om.menu_id = m.menu_id and o.customer_id = ?");
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				totalPrice = rs.getInt("total");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		return totalPrice;
	}
	
	public double getTotalPriceByOrderId(int orderId) {
		
		int totalPrice = 0;
		
		if(con == null)
			con = ConnectionProvider.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("select sum(m.menu_price * om.quantity) as total from ordermenu om, "
					+ "orders o, menu m where om.order_id = o.order_id and om.menu_id = m.menu_id and o.order_id = ?");
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				totalPrice = rs.getInt("total");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		return totalPrice;
	}
	
	public int getOrderIdByCustomerId(int customerId){
		int orderId = 0;
		
		if(con == null)
			con = ConnectionProvider.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("select order_id from orders where customer_id = ?");
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				orderId = rs.getInt("order_id");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		return orderId;
	}
	
}
