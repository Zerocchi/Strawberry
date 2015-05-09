package com.zerocchi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zerocchi.bean.User;
import com.zerocchi.connection.ConnectionProvider;

public class UserDao {

	private Connection con;
	
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
}
