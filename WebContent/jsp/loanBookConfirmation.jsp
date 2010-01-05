<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LibraryManager/css/default.css" />
<title>Register a new loan - Confirmation</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<h4>The book has just been loaned successfully!</h4>
<table>
	<tr>
		<td>User</td>
		<td>${user}</td>
	</tr>
	<tr>
		<td>Book</td>
		<td>${book}</td>
	</tr>
	<tr>
		<td>start Date</td>
		<td>${startDate}</td>
	</tr>
</table>
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