<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About me</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/about.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/base.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/media.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/style.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/index.css"
	type="text/css">
</head>
<body>
	<div class="ibody">
		<header>
			<h1>So Cool!</h1>
			<h2>If you never try, you will never know!</h2>
			<%@ include file="navigation.jsp"%>
		</header>
		<article>
			<h3 class="about_h">
				You now as:<a href="index">Index</a>>><a href="aboutme">About me</a>
			</h3>
			<div class="about">
				<h2 align="center">Just about me, about my blog</h2>
				<!--       <ul class="blog_a"> -->
				<!--         <p>Name: Wei Li</p> -->
				<!--         <p>Job: Student</p> -->
				<!--       </ul> -->
				<h2>Name: ${aboutme.nickname}</h2>
				<h2>Job: Student</h2>
				<h2>School: GWU</h2>
				<h2>Phone: 2028122724</h2>
				<h2>Email: ${aboutme.email}</h2>
			</div>
<%-- 			<c:forEach items="${test}" var="article">
			           Id: ${article.id}
			</c:forEach> --%>
		</article>

		<aside>
			<%@ include file="information.jsp"%>
			<div class="links">
				<h2>
					<p>Link</p>
				</h2>
				<ul>
					<li><a href="http://www.facebook.com">Facebook</a></li>
					<li><a href="http://www.twitter.com">Twitter</a></li>
					<li><a href="https://wx.qq.com/"> Wechat</a></li>
					<li><a href="http://www.qq.com"> QQ</a></li>
				</ul>
			</div>
			<%@ include file="copyright.jsp"%>
		</aside>
		<div class="clear"></div>
		<!-- 清除浮动 -->
	</div>
</body>
</html>