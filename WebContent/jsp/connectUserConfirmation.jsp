<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>

<title>Connect user - Confirmation</title>
</head>
<body>
<h3>Your are connected !</h3>
<table>
		<tr>
			<td>Login</td>
			<td>${login}</td>
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
</body>
</html>