<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Search a user account - Confirmation</title>
</head>
<body>

<h4>The results</h4>

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
		<td>
		<h4>Type</h4>
		</td>
	</tr>
	<c:forEach var="user" items="${query}">
		<tr>
			<td>${user.login}</td>
			<td>${user.lastName}</td>
			<td>${user.firstName}</td>
			<td>${user.email}</td>
			<td>${user.class.simpleName}</td>
			<td><a
				href="javascript:document.getElementById('form').submit();"
				onclick="javascript:document.getElementById('delete').setAttribute('value','${user.login}')">
			delete </a></td>
		</tr>
	</c:forEach>

</table>

<form:form id="form" method="post"
	action="/LibraryManager/deleteUserAccount.action">
	<input id="delete" name="deleteLogin" type="hidden" />
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