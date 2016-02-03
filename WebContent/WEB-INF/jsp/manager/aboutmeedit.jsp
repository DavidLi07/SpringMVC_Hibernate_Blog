<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/Resources/css/about.css" type ="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/Resources/css/base.css" type ="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/Resources/css/media.css" type ="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/Resources/css/style.css" type ="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/Resources/css/index.css" type ="text/css">
</head>
<body>
<div class="ibody">
  <header>
    <h1>So Cool!</h1>
    <h2>If you never try, you will never know!</h2>
    <%@ include file="managernavi.jsp" %>
    </header>
  <article>
    <h3 class="about_h">You now as:<a href="http://localhost:8080/SpringMVC_Blog/manager/index">Index</a>>><a href="http://localhost:8080/SpringMVC_Blog/manager/aboutme">About me</a>&nbsp;&nbsp;&nbsp;<a href="aboutmeedit">Edit</a></h3>
    <div class="about">
	  <h2 align="center">Just about me, about my blog</h2>
      <ul class="blog_a">
<sf:form method="post" modelAttribute="user">
<div align="center">
<table width ="700" border="1">
	<tr>
	<td>User Name:</td><td>${user.username} <sf:hidden path="username"/></td>
	</tr>
	<tr>
	<td>Password:</td><td> <sf:password path="password"/><sf:errors path="password"/> </td>
	</tr>
	<tr>
	<td>Nick Name:</td><td> <sf:input path="nickname"/> </td>
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
</div>
</sf:form>
      </ul>
    </div>
    </article>
   <aside>
    <%@ include file="information.jsp" %>
    <div class="links">
      <h2>
      <p>Link</p>
      </h2>
      <ul>
        <li><a href="http://www.facebook.com">Facebook</a></li>
        <li><a href="http://www.twitter.com">Twitter</a></li>
        <li> <a href="https://wx.qq.com/"> Wechat</a></li>
        <li> <a href="http://www.qq.com"> QQ</a></li>
      </ul>
    </div>
    <%@ include file="../copyright.jsp" %> 
  </aside>
  <div class="clear"></div>
  <!-- 清除浮动 --> 
  </div>
</body>
</html>