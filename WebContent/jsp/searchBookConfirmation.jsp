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
		<h4>ISBN</h4>
		</td>
		<td>
		<h4>Author</h4>
		</td>
		<td>
		<h4>Editor</h4>
		</td>
		<td>
		<h4>Initial Stock</h4>
		</td>
		<td>
		<h4>Remaining Stock</h4>
		</td>
	</tr>
	<c:forEach var="stock" items="${query}">
		<tr>
			<td>${stock.book.isbn}</td>
			<td>${stock.book.author}</td>
			<td>${stock.book.editor}</td>
			<td>${stock.totalStock}</td>
			<td>${stock.remainingStock}</td>
			<td><a
				href="javascript:document.getElementById('form').submit();"
				onclick="javascript:document.getElementById('delete').setAttribute('value','${stock.book.isbn}')">
			delete </a></td>
		</tr>
	</c:forEach>

</table>

<form:form id="form" method="post"
	action="/LibraryManager/deleteBook.action">
	<input id="delete" name="deleteISBN" type="hidden" />
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