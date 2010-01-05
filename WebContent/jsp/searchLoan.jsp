<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="librarymanager.core.Customer"%>
<%@page import="librarymanager.core.LibraryWorker"%>
<%@page import="librarymanager.core.Admin"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="user" class="librarymanager.core.User" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="librarymanager.core.LibraryWorker"%><html>
<head>
<link rel="stylesheet" type="text/css"
	href="/LibraryManager/css/default.css" />
<title>Search a loan</title>
</head>
<body>
<div id="header"></div>
<div id="content">
<h4>The results</h4>
<%
	if (user instanceof Customer)
		out.println("<h5>You're a user, only your loans appear</h5>");
	else if (user instanceof LibraryWorker)
	out.println("<h5>You're a library worker, all loans appear</h5>");
	else if (user instanceof Admin)
		out.println("<h5>You're an administrator, all loans appear</h5>");
%>
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
</form:form> <br />
</div>
<div id="footer"><a
	href="/LibraryManager/jsp/connectUserConfirmation.jsp">Home - Page</a>
<br />
<a href="/LibraryManager/jsp/connectUserForm.jsp">Log out</a></div>
</body>
</html>