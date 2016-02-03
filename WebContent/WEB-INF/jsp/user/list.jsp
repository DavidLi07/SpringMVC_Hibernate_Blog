<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
</head>
<body>
<h1>User List</h1>
<a href="add">Add User</a>
<a href="users">User List</a>
<a href="logout">Log out</a>
Current User:${loginUser.nickname}

<hr/>
<table width="1000" align="center" border="1">
<tr>
<td>UserId</td><td>UserName</td><td>UserNickname</td><td>UserPassword</td><td>UserEmail</td><td>Operations</td>
        <c:forEach items="${list}" var="u">
          <tr>
          <td>${u.id }</td><td><a href="${u.id}">${u.username }</a></td><td>${u.nickname}</td><td>${u.password }</td><td>${u.email }</td>
            <td><a href = "${u.id}/update">Update</a> &nbsp; <a href = "${u.id}/delete">Delete</a></td>
          </tr>
        </c:forEach>
</tr>
</table>
</body>
</html>