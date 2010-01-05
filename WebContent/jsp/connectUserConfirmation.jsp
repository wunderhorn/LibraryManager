<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="librarymanager.core.Customer"%>
<%@page import="librarymanager.core.Admin"%>
<%@page import="librarymanager.core.LibraryWorker"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="user" class="librarymanager.core.User" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LibraryManager/css/default.css" />
<title>Homepage</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<%!String userType;%>

<%
	if (user instanceof Customer)
		userType = "Customer";
	if (user instanceof LibraryWorker)
		userType = "Library worker";
	if (user instanceof Admin)
		userType = "Administrator";
%>
<div id="menu">
<h4>You are connected as a <%=userType%></h4>

<h5>Please choose your action</h5>
<%
	out
			.println("<a href='/LibraryManager/jsp/manageLoans.jsp'>Manage loans</a><br/><br/>");

	if (user instanceof LibraryWorker || user instanceof Admin) {
		out
				.println("<a href='/LibraryManager/jsp/manageBooks.jsp'>Manage books</a><br/><br/>");
		if (user instanceof Admin)
			out
					.println("<a href='/LibraryManager/jsp/manageUsers.jsp'>Manage users</a>");
	}
%>
</div>
<br />
<br />
</div>
<div id="footer">
<a href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home -
Page</a>
<br />
<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a>
</div>
</body>
</html>