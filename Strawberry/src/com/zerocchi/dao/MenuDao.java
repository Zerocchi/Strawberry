package com.zerocchi.dao;
import com.zerocchi.bean.Menu;
import com.zerocchi.connection.ConnectionProvider;

import java.sql.*;  
import java.util.ArrayList;
import java.util.List;


public class MenuDao {  
	
	/**
	 * Menu Data Access Object.
	 * Control the menu database flow.
	 */
	
	private static int STATUS=0;  
	private Connection con;
	
	public MenuDao() {}
  
	// Add menu into database
	public int addMenu(Menu m){  
				  
		try {
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("insert into menu (menu_id, menu_name, menu_price) "
					+ "values(menu_sequence.nextval, ?,?)");  
			ps.setString(1,m.getMenuName());  
			ps.setFloat(2,(float) m.getMenuPrice());    
			              
			STATUS=ps.executeUpdate();  
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return STATUS;
	}
	
	// Delete menu from database
	public int deleteMenu(int menuId){
		
		try {    
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("delete from menu where menu_id = ?");
			ps.setInt(1,menuId);     
			              
			STATUS=ps.executeUpdate(); 
			
		}catch(Exception e){
				e.printStackTrace();
		}    
		return STATUS; 
	}
	
	// Update or edit menu from database
	public int updateMenu(Menu m){
		try {  
			if(con == null)
				con = ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("update menu set menu_name=?, menu_price=?"
					+ "where menu_id=?");
			ps.setString(1,m.getMenuName());
			ps.setFloat(2,(float)m.getMenuPrice());
			ps.setInt(3,m.getMenuId());
			              
			STATUS=ps.executeUpdate();  
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		return STATUS; 
	}
	
	// get menu by its name
	public Menu getMenuByName(String name) {
		if(con == null)
			con = ConnectionProvider.getCon();
		Menu menu = new Menu();
		try {
			PreparedStatement ps = con.prepareStatement("select distinct menu_id, menu_name, menu_price from menu"
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
	
	public Menu getMenuById(int menuId) {
		if(con == null)
			con = ConnectionProvider.getCon();
		Menu menu = new Menu();
		try {
			PreparedStatement ps = con.prepareStatement("select distinct menu_id, menu_name, menu_price from menu"
					+ " where menu_id = ? ");
			ps.setInt(1, menuId);
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
		if(con == null)
			con = ConnectionProvider.getCon();
		List<Menu> menus = new ArrayList<>();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from menu order by menu_id");
			
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