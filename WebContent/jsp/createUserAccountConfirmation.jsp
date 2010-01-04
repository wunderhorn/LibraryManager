<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Create a new account - Confirmation</title>
</head>
<body>
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
	<a href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home - Page</a>
	<br />
	<br />
	<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a>
</body>
</html>