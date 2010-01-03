<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>

<title>Search a user account - Confirmation</title>
</head>
<body>

<table border="1">
	<tr>
		<td>
		<h4>Login</h4>
		</td>
		<td>
		<h4>LastName</h4>
		</td>
		<td>
		<h4>FirstName</h4>
		</td>
		<td>
		<h4>Email</h4>
		</td>
	</tr>
	<c:forEach var="user" items="${query}">
		<tr>
			<td>${user.login}</td>
			<td>${user.lastName}</td>
			<td>${user.firstName}</td>
			<td>${user.email}</td>
			<td><a
				href="javascript:document.getElementById('form').submit();"
				onclick="javascript:document.getElementById('delete').setAttribute('value','${user.login}');document.getElementById('form').setAttribute('action','deleteUserAccount.action')">
			 delete 
			</a></td>
		</tr>
	</c:forEach>

</table>

<form:form id="form" method="post">
	<input id="delete" name="deleteLogin" type="hidden" />
</form:form>

</body>
</html>