<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="librarymanager.ui.ErrorConnectException,librarymanager.core.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
	session.invalidate();
%>

<jsp:useBean id="errorConnectException"
	class="librarymanager.ui.ErrorConnectException" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/LibraryManager/css/default.css" />
<title>Connect user</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<h4>Connect now !</h4>

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
	<div id="error">${errorConnectException.message}</div>
</form:form> <br />
<br />
if you haven't got an account, ask the administrator</div>
<div id="footer">Projet JEE - EFREI - IL - 2010<br />
Bourdon Aurelien - Lallemand Matthieu - Roget Gabriel</div>
</body>
</html>