package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.employee.util.DBUtil;

public class EmployeeDetails {

	
	
	public boolean isValidUser(String username, String password) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int flag = 0;
		
		try {
			String data = "Select * from login";
			connection = DBUtil.getConnection();
			//System.out.println(connection);
			stmt = connection.prepareStatement(data);
			//System.out.println(stmt);
			rs = stmt.executeQuery();
			//System.out.println(rs);
			
			
			while (rs.next()) {
				if (username.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
					flag = 1;
					break;
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}

	}
   public List<String> belowAge(int age) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int flag = 0;
		ArrayList<String> list = new ArrayList<>();
		try {
			String data = "Select * from EmployeeDetails";
			connection = DBUtil.getConnection();
			//System.out.println(connection);
			stmt = connection.prepareStatement(data);
			//System.out.println(stmt);
			rs = stmt.executeQuery();
			//System.out.println(rs);
		
			
			while(rs.next()) {
				//Employee employee = new Employee();
				if(rs.getInt(3) < age) {
					list.add(rs.getString(3));
				}
			}
	
   }catch (Exception e) {
	// TODO: handle exception
}
		return list;
}
}