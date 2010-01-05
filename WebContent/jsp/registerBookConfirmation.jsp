<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LibraryManager/css/default.css" />
<title>Register a new book - Confirmation</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<h4>The book has just been registered successfully!</h4>
<table>
	<tr>
		<td>ISBN</td>
		<td>${isbn}</td>
	</tr>
	<tr>
		<td>Author</td>
		<td>${author}</td>
	</tr>
	<tr>
		<td>Editor</td>
		<td>${editor}</td>
	</tr>
	<tr>
		<td>Stock</td>
		<td>${stock}</td>
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