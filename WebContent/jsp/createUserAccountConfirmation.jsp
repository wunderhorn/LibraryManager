<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LibraryManager/css/default.css" />
<title>Create a new account - Confirmation</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<h4>The account has just been created successfully!</h4>
<table>
	<tr>
		<td>Login</td>
		<td>${login}</td>
	</tr>
	<tr>
		<td>Password</td>
		<td>${password}</td>
	</tr>
	<tr>
		<td>LastName</td>
		<td>${lastName}</td>
	</tr>
	<tr>
		<td>FirstName</td>
		<td>${firstName}</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>${email}</td>
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