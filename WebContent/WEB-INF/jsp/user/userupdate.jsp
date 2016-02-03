<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
</head>
<body>
<h1 align="center">Update User</h1>
<sf:form method="post" modelAttribute="user">
<table width=700 align="center" border="1">
<!-- 	<tr> -->
<%-- 	<td>ID:</td><td> <sf:input path="id"/> </td> --%>
<!-- 	</tr> -->
	<tr>
	<td>UserName:</td><td>${user.username} <sf:hidden path="username"/></td>
	</tr>
	<tr>
	<td>Password:</td><td> <sf:password path="password"/><sf:errors path="password"/> </td>
	</tr>
	<tr>
	<td>NickName:</td><td> <sf:input path="nickname"/> </td>
	</tr>
	<tr>
	<td>Email:</td><td> <sf:input path="email"/><sf:errors path="email"/> </td>
	</tr>
	<tr>
	<td colspan="2">
	<input type="submit" value="Update User"/>
    </td>
	</tr>

</table>

</sf:form>
</body>
</html>