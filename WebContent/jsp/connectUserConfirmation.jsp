<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="librarymanager.core.Customer"%>
<%@page import="librarymanager.core.Admin"%>
<%@page import="librarymanager.core.LibraryWorker"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="user" class="librarymanager.core.User" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>
<%!String userType;%>

<%
	if (user instanceof Customer)
		userType = "Customer";
	if (user instanceof LibraryWorker)
		userType = "Library worker";
	if (user instanceof Admin)
		userType = "Administrator";
%>

<h4>You are connected as a <%=userType%></h4>

<h5>Please choose your action:</h5>
<%
	out
			.println("<a href='/LibraryManager/jsp/manageLoans.jsp'>Manage loans</a>");

	if (user instanceof LibraryWorker || user instanceof Admin) {
		out
				.println("<a href='/LibraryManager/jsp/manageBooks.jsp'>Manage books</a>");
		if (user instanceof Admin)
			out
					.println("<a href='/LibraryManager/jsp/manageUsers.jsp'>Manage users</a>");
	}
%>
<br />
<br />
	<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a>
</body>
</html>