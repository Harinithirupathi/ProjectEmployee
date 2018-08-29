package com.datainsertionindb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.util.DBUtil;

/**
 * Servlet implementation class DataInsertionInDB
 */
@WebServlet("/DataInsertionInDB")
public class DataInsertionInDB extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Data Inserted into the Database<h1>");
		// doGet(request, response);
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String salary = request.getParameter("salary");
		String email = request.getParameter("email");
		String mobilenumber = request.getParameter("mobilenumber");

		// out.println("<h1>Name = " + name + "<h1>");
		String sql = "insert into EmployeeDetails(Name,Age,Date_Of_Birth,Address,Salary,Email,MobileNumber)values(?,?,?,?,?,?,?)";
		Connection connection = DBUtil.getConnection();
		PreparedStatement prepareStatement = null;
		try {

			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, age);
			prepareStatement.setString(3, dob);
			prepareStatement.setString(4, address);
			prepareStatement.setString(5, salary);
			prepareStatement.setString(6, email);
			prepareStatement.setString(7, mobilenumber);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
