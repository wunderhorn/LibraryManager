<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="deleteBookException"
	class="librarymanager.ui.DeleteBookException" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/LibraryManager/css/default.css" />
<title>Delete book - Confirmation</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<%
	if (deleteBookException.getMessage().isEmpty())
		out.println("<h4>Book deleted OK !</h4>");
	else
		out.println("<h4 id=\"error\">" + deleteBookException.getMessage()
				+ "</h4>");
%> <br />
</div>
<div id="footer"><a
	href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home - Page</a>
<br />
<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a></div>
</body>
</html>