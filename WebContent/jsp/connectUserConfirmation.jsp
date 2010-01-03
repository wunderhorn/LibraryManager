<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="user" class="librarymanager.core.User" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<%@page import="librarymanager.core.Customer"%>
<%@page import="librarymanager.core.Admin"%>
<%@page import="librarymanager.core.LibraryWorker"%>
<%@page
	import="com.sun.org.apache.xml.internal.security.transforms.params.InclusiveNamespaces"%><html
	xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
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

</body>
</html>