<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Register a new book - Confirmation</title>
</head>
<body>
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
<hr />
<a href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home -
Page</a>
<br />
<br />
<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a>
</body>
</html>