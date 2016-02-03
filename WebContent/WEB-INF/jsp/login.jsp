<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
			<h2 class="about_h">
				You now as:<a href="http://localhost:8080/SpringMVC_Blog/index">Index</a>>><a
					href="http://localhost:8080/SpringMVC_Blog/login">Login</a>
			</h2>

			<div class="template">
				<h3>
					<p>
						<span>Login</span>
					</p>
				</h3>
				<div style="font-size: 16pt; margin: 0 auto;">
					<form method="post">
						<table style="margin: 80px auto;">
							<tr>
								<td>Username:</td>
								<td><input type="text" name="username"></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="password"></td>
							</tr>
							<tr>
								<td><input type="submit" value="Login"><br></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
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