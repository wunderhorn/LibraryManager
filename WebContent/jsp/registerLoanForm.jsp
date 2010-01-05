<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="registerLoanException"
	class="librarymanager.ui.RegisterLoanException" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/LibraryManager/css/default.css" />
<title>Register a new loan</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<h4>Search a book to loan</h4>

<form:form method="post" name="registerLoanForm"
	action="/LibraryManager/registerLoan.action">
	<table>
		<tr>
			<td>ISBN</td>
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
			<td><input type="submit" value="search books" /></td>
		</tr>
	</table>

</form:form>
<div id="error">${registerLoanException.message}</div>
<br />
</div>
<div id="footer"><a
	href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home - Page</a>
<br />
<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a></div>
</body>
</html>