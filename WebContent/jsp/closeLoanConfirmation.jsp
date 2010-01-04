<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="closeLoanException"
	class="librarymanager.ui.CloseLoanException" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Close loan - Confirmation</title>
</head>
<body>
<%
	if (closeLoanException.getMessage().isEmpty())
		out.println("<h4>Loan closed OK !</h4>");
	else
		out.println("<h4>" + closeLoanException.getMessage() + "</h4>");
%>

<br />
<hr />
<a href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home -
Page</a>
<br />
<br />
<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a>
</body>
</html>