package com.reportform;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDetails;


@WebServlet("/reportform")
public class reportform extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int age =Integer.parseInt( request.getParameter("age"));
	EmployeeDetails emp = new EmployeeDetails();
		
	List<String> emplist = emp.belowAge(age);
	request.setAttribute("emplist",emplist);
	RequestDispatcher rd = request.getRequestDispatcher("report.jsp");
	rd.include(request, response);
		
	}

}
