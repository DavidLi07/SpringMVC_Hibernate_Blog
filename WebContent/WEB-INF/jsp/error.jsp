<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
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
				You now as:<a href="http://localhost:8080/SpringMVC_Blog/index">Index</a>>><a href="http://localhost:8080/SpringMVC_Blog/login">Login</a>
			</h3>
			<div class="about">
              <h2>${exception.message}</h2>
              <a href="http://localhost:8080/SpringMVC_Blog/login">Return</a>
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