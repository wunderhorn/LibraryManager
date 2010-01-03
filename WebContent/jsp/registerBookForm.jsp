<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="registerBookException"
	class="librarymanager.ui.RegisterBookException"
	scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>

<title>Register a new book</title>
</head>
<body>

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

	${registerBookException.message}

</form:form>

</body>
</html>