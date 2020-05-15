<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login Form</title>
<style type="text/css">
.failed {
	color: red;
}
</style>
</head>
<body>
	<h1>My custom login page</h1>
	<form:form action="${pageContent.request.contextPath}authenticateUser"
		method="POST">
		<c:if test="${param.error!=null}">
			<i class="failed">Sorry! you entered invalid username/password</i>

		</c:if>
		<c:if test="${param.logout!=null}">
			<i class="failed">You are logged out .</i>

		</c:if>
		<p>
			User Name:<input type="text" name="username" />
		</p>
		<p>
			Password:<input type="password" name="password" />
		</p>
		<p>
			<input type="submit" value="Login" />
		</p>


	</form:form>
</body>
</html>