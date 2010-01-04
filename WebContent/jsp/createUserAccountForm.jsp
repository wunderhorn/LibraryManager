<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="extremlyBadCreateUserException"
	class="librarymanager.ui.ExtremlyBadCreateUserException"
	scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Create a new user account</title>
</head>
<body>

<h4>Create a  new user account !</h4>

<form:form method="post" name="createUserAccountForm"
	action="/LibraryManager/createUserAccount.action">
	<table>
		<tr>
			<td>Login</td>
			<td><input type="text" name="login" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="password" /></td>
		</tr>
		<tr>
			<td>LastName</td>
			<td><input type="text" name="lastName" /></td>
		</tr>
		<tr>
			<td>FirstName</td>
			<td><input type="text" name="firstName" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>Type</td>
			<td><select name="type">
				<option value="Customer">Customer</option>
				<option value="Admin">Admin</option>
				<option value="LibraryWorker">Library worker</option>
			</select></td>
		</tr>
		<tr>
			<td><input type="submit" value="Create account" /></td>
		</tr>
	</table>

	${extremlyBadCreateUserException.message}

</form:form>
<br />
<hr />
<a href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home -
Page</a>
<br />
<br />
<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a>
</body>
</html>