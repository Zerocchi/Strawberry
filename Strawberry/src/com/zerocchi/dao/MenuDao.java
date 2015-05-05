package com.zerocchi.dao;
import com.zerocchi.bean.Menu;
import com.zerocchi.connection.ConnectionProvider;

import java.sql.*;  


public class MenuDao {  
	
	private static int STATUS=0;  
	private static Connection con = null;
  
	public static int add(Menu m){  
			
		try{  
			if(con == null || !con.isClosed())
				con=ConnectionProvider.getCon();   
			PreparedStatement ps=con.prepareStatement("insert into cafemenu (menu_id, menu_name, menu_price) "
					+ "values(menu_seqence.nextval, ?,?)");  
			ps.setString(1,m.getMenuName());  
			ps.setFloat(2,(float) m.getMenuPrice());    
			              
			STATUS=ps.executeUpdate();  
			con.close();
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		      
			return STATUS;  
	}
	
	public static int delete(Menu m){
		
		try{  
			if(con == null || !con.isClosed())
				con=ConnectionProvider.getCon();   
			PreparedStatement ps=con.prepareStatement("delete from cafemenu where menu_name = ?");
			ps.setString(1,m.getMenuName());     
			              
			STATUS=ps.executeUpdate(); 
			con.close();
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		      
			return STATUS; 
	}
	
	public static int update(Menu m, String tempMenu){
		// how to determine the 'where' clause
		try{  
			if(con == null || !con.isClosed())
				con=ConnectionProvider.getCon();   
			PreparedStatement ps=con.prepareStatement("update cafemenu set menu_name=?, menu_price=?"
					+ "where menu_name=?");
			ps.setString(1,m.getMenuName());
			ps.setFloat(2,(float)m.getMenuPrice());
			ps.setString(3,tempMenu);
			              
			STATUS=ps.executeUpdate();  
			con.close();
			
		}catch(Exception e){
				e.printStackTrace();
		}  
		      
			return STATUS; 
			
	}
	  
}  