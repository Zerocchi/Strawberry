package com.zerocchi.dao;
import com.zerocchi.bean.Menu;
import com.zerocchi.connection.ConnectionProvider;

import java.sql.*;  
import java.util.ArrayList;
import java.util.List;


public class MenuDao {  
	
	private static int STATUS=0;  
	private static Connection con = null;
	
	public MenuDao() {
		// Prepare connection
		con = ConnectionProvider.getCon();
	}
  
	// Add menu into database
	public static int addMenu(Menu m){  
				  
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into cafemenu (menu_id, menu_name, menu_price) "
					+ "values(menu_seqence.nextval, ?,?)");  
			ps.setString(1,m.getMenuName());  
			ps.setFloat(2,(float) m.getMenuPrice());    
			              
			STATUS=ps.executeUpdate();  
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return STATUS;
	}
	
	// Delete menu from database
	public static int deleteMenu(Menu m){
		
		try {    
			
			PreparedStatement ps=con.prepareStatement("delete from cafemenu where menu_name = ?");
			ps.setString(1,m.getMenuName());     
			              
			STATUS=ps.executeUpdate(); 
			
		}catch(Exception e){
				e.printStackTrace();
		}    
		return STATUS; 
	}
	
	// Update or edit menu from database
	public static int updateMenu(Menu m, String tempMenu){
		// how to determine the 'where' clause
		try {  
			
			PreparedStatement ps=con.prepareStatement("update cafemenu set menu_name=?, menu_price=?"
					+ "where menu_name=?");
			ps.setString(1,m.getMenuName());
			ps.setFloat(2,(float)m.getMenuPrice());
			ps.setString(3,tempMenu);
			              
			STATUS=ps.executeUpdate();  
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		return STATUS; 
	}
	
	// get menu by its name
	public Menu getMenuByName(String name) {
		Menu menu = new Menu();
		try {
			PreparedStatement ps = con.prepareStatement("select menu_id, menu_name, menu_price from cafemenu"
					+ " where lower(menu_name) like ? ");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				menu.setMenuId(rs.getInt("menu_id"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuPrice(rs.getDouble("menu_price"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return menu;
	}
	
	// get all the menus
	public List<Menu> getAllMenu() {
		List<Menu> menus = new ArrayList<>();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from cafemenu");
			
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenuId(rs.getInt("menu_id"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuPrice(rs.getDouble("menu_price"));
				menus.add(menu);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return menus;
	}
}  