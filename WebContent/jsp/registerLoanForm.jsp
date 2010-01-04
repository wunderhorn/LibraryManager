<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="registerLoanException"
	class="librarymanager.ui.RegisterLoanException" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Register a new loan</title>
</head>
<body>

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
${registerLoanException.message}
<br />
<a href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home -
Page</a>
	<br />
	<br />
	<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a>
</body>
</html>