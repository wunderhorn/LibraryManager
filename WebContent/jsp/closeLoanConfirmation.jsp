<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="closeLoanException"
	class="librarymanager.ui.CloseLoanException" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LibraryManager/css/default.css" />
<title>Close loan - Confirmation</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<%
	if (closeLoanException.getMessage().isEmpty())
		out.println("<h4>Loan closed OK !</h4>");
	else
		out.println("<h4 id=\"error\">" + closeLoanException.getMessage() + "</h4>");
%>

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