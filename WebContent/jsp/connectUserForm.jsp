<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="librarymanager.ui.ErrorConnectException,librarymanager.core.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="errorConnectException"
	class="librarymanager.ui.ErrorConnectException" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connect user</title>
</head>
<body>

<% User user = (User)session.getAttribute("user");
if( user!= null)
	user = null; %>
	
<form:form name="connectUserForm" method="post"
	action="/LibraryManager/connectUser.action">
	<table>
		<tr>
			<td>Login</td>
			<td><input name="login" type="text" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input name="password" type="password" /></td>
		</tr>
		<tr>
			<td><input name="reset" type="reset" value="Reset" /></td>
			<td><input name="submit" type="submit" value="Connect" /></td>
		</tr>
	</table>

	${errorConnectException.message}

</form:form>

</body>
</html>