<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>

<title>Search a new account</title>
</head>
<body>

<form:form method="post" name="searchUserAccountForm" action="../searchUserAccount.action">
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

</body>
</html>