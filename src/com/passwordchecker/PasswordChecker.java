package com.passwordchecker;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDetails;

@WebServlet("/PasswordChecker")
public class PasswordChecker extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("doPost() called");
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
//		out.println(username);
//		out.println(password);
		EmployeeDetails empDetails = new EmployeeDetails();
		
		if (empDetails.isValidUser(username, password)) {
			out.println("Login Successful");
			RequestDispatcher rd = request.getRequestDispatcher("/EmployeeDetails.html");
			rd.include(request, response);
		} else {
			out.println("<h1>OOPS!!! You have entered the Wrong UserName or Password<h1>");
		}
	}
}
