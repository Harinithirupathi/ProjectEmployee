<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
</head>
<body>
	<table cellspacing="10" cellpadding="10" border="3">

		<%
			int count = 0;
			out.println("<h2>The Employee Details :<br></h2>");
			List<String> list = (List<String>) request.getAttribute("emplist");
			for (String employee : list) {
				count++;
				out.println("The total Number is Employees below the Age are : " + count + " <br> ");
				out.println("<center><tr> <td> " + employee + "</td> </tr></center>");

			}
		%>

	</table>
</body>
</html>