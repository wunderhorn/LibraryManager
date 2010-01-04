<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Search a loan</title>
</head>
<body>

<h4>Choose a loan</h4>

<table border="1">
	<tr>
		<td>
		<h4>Book ISBN</h4>
		</td>
		<td>
		<h4>Book author</h4>
		</td>
		<td>
		<h4>Book editor</h4>
		</td>
		<td>
		<h4>User</h4>
		</td>
		<td>
		<h4>start Date</h4>
		</td>
		<td>
		<h4>end Date</h4>
		</td>
	</tr>
	<c:forEach var="loan" items="${query}">
		<tr>
			<td>${loan.book.isbn}</td>
			<td>${loan.book.author}</td>
			<td>${loan.book.editor}</td>
			<td>${loan.user.login}</td>
			<td>${loan.startDate}</td>
			<td>${loan.endDate}</td>
			<td><a
				href="javascript:document.getElementById('form').submit();"
				onclick="javascript:document.getElementById('closeBook').setAttribute('value','${loan.book.isbn}');document.getElementById('closeUser').setAttribute('value','${loan.user.login}')">
			close </a></td>
		</tr>
	</c:forEach>

</table>

<form:form id="form" method="post"
	action="/LibraryManager/closeLoan.action">
	<input id="closeBook" name="closeBook" type="hidden" />
	<input id="closeUser" name="closeUser" type="hidden" />
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