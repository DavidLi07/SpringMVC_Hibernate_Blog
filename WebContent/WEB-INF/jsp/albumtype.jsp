<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Album</title>
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
				You now as:<a href="http://localhost:8080/SpringMVC_Blog/index">Index</a>>><a href="http://localhost:8080/SpringMVC_Blog/album">Album</a>
			</h2>
			<div class="template">
				<h3>
					<p><span>My album</span></p>
				</h3>
				</div>
			<ul>
				<c:forEach items="${album}" var="album">
					<p>
						<a href="${album.albumid }/albumdetail">${album.album}</a>
					</p>
					<li><a href="${album.albumid }/albumdetail"><img
							src="<%=request.getContextPath()%>${album.photo}" width="240px" height="120"/></a></li>
				</c:forEach>
			</ul>
		</article>

		<aside>
			<%@ include file="information.jsp"%>
			<div class="rnav">
				<ul>
					<li class="rnav1 "><a href="http://localhost:8080/SpringMVC_Blog/albumme">Me</a></li>
					<li class="rnav2 "><a href="http://localhost:8080/SpringMVC_Blog/albumcool">Cool</a></li>
					<li class="rnav3 "><a href="http://localhost:8080/SpringMVC_Blog/albumbeauty">Beauty</a></li>
					<li class="rnav4 "><a href="http://localhost:8080/SpringMVC_Blog/albumsea">Sea</a></li>
				</ul>
			</div>
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