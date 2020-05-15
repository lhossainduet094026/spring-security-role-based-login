<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>spring security demo</title>
</head>
<body>
	<h1>home page for demo security</h1>
	<hr>
	<p>
		User:<b><sec:authentication property="principal.username" /></b> <br>
		Role(s):<b><sec:authentication property="principal.authorities" /></b>
	</p>
<hr>
	<br>
	<sec:authorize access="hasRole('MANAGER')">
	
	<!-- Add a link to point to leaders/.......this is for manages -->
	<p>
		<a href="${pageContent.request.contextPath}leaders/">LeaderShip
			Meeting</a> (only for manager peeps)
	</p>

	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN')">
	<!-- Add a link to point to Systems/.......this is for Admin -->
	<p>
		<a href="${pageContent.request.contextPath}systems/">IT System
			Meeting</a> (only for admin peeps)
	</p>
	</sec:authorize>
	<hr>
	<form:form action="${pageContent.request.contextPath}logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>

</body>
</html>