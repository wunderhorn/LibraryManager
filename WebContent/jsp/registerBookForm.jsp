<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="registerBookException"
	class="librarymanager.ui.RegisterBookException" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LibraryManager/css/default.css" />
<title>Register a new book</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<h4>Register a new book</h4>

<form:form method="post" name="registerBookForm"
	action="/LibraryManager/registerBook.action">
	<table>
		<tr>
			<td>ISNB</td>
			<td><input type="text" name="isbn" /></td>
		</tr>
		<tr>
			<td>Author</td>
			<td><input type="text" name="author" /></td>
		</tr>
		<tr>
			<td>Editor</td>
			<td><input type="text" name="editor" /></td>
		</tr>
		<tr>
			<td>Stock</td>
			<td><input type="text" name="stock" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Regiser book" /></td>
		</tr>
	</table>

	<div id="error">${registerBookException.message}</div>

</form:form>
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