<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User [${user.nickname}] Data</title>
</head>
<body>
<h1 align="center">User [${user.nickname}] Data</h1>
<table width=700 align="center" border="1">
	<tr>
	<td>ID:</td><td>${user.id}</td>
	</tr>
	<tr>
	<td>UserName:</td><td>${user.username}</td>
	</tr>
		<tr>
	<td>Password:</td><td>${user.password}</td>
	</tr>
	<tr>
	<td>NickName:</td><td>${user.nickname}</td>
	</tr>
	<tr>
	<td>Email:</td><td>${user.email}</td>
	</tr>
</table>

</body>
</html>