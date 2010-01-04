<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Search a new account</title>
</head>
<body>

<h4>Search user account</h4>

<form:form method="post" name="searchUserAccountForm"
	action="/LibraryManager/searchUserAccount.action">
	<table>
		<tr>
			<td>Login</td>
			<td><input type="text" name="login" /></td>
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
			<td><input type="submit" value="search users" /></td>
		</tr>
	</table>

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