<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Register a new loan - Confirmation</title>
</head>
<body>
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
	<a href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home - Page</a>
</body>
</html>