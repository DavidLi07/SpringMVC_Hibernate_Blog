<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/about.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/style.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/base.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/index.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/media.css"
	type="text/css">
</head>

<body>
	<div class="ibody">
		<header>
			<h1>So Cool~</h1>
			<h2>If you never try, you will never know!</h2>
			<%@ include file="navigation.jsp"%>
		</header>

		<article>
			<div class="banner">
				<ul class="texts">
					<p>The best life is use of willing attitude, a happy-go-lucky
						life.</p>
				</ul>
			</div>
			<div class="bloglist">
				<h2>Recommendation</h2>
			</div>

			<div class="bloglist">
				<c:forEach items="${load}" var="loadarticle">
					<div class="blogs">

						<h3>
							<a href="${loadarticle.id}/articledetail">${loadarticle.title}</a>
						</h3>
						<%-- 	        <figure><img src="<%=request.getContextPath()%>/Resources/images/1.jpg">${u.photo}</figure> --%>
						<figure>
							<img src="<%=request.getContextPath()%>${loadarticle.photo}">
						</figure>
						<ul>
							<li><div class="content" style="height: 12em; clear: both;">${loadarticle.content}</div>
								<a href="${loadarticle.id}/articledetail">Get whole&gt;&gt;</a>
							</li>
						</ul>
						<p class="autor">
							<span>Author:${loadarticle.author}</span> <span>Type:${loadarticle.type}</span><span><a
								href="${loadarticle.id}/articledetail">Comment</a></span>
						</p>
						<div class="dateview">${loadarticle.bdate}</div>
					</div>
				</c:forEach>
			</div>
		</article>

		<aside>
			<%@ include file="information.jsp"%>
			<div class="tj_news">
				<h2>
					<p class="tj_t1">New articles</p>
				</h2>
				<ul>
					<c:forEach items="${loadnew}" var="loadnew">
						<li><a href="${loadnew.id}/articledetail">${loadnew.title}</a></li>
					</c:forEach>
					<%--       <li><a href="${load.id}/articledetail">${load.title}</a></li> --%>
					<%--       <li><a href="${loadarticle.id}/articledetail">${loadarticle.title}</a></li> --%>
				</ul>

				<h2>
					<p class="tj_t2">Recommend</p>
				</h2>
				<ul>
					<c:forEach items="${load}" var="loadre">
						<li><a href="${loadre.id}/articledetail">${loadre.title}</a></li>
					</c:forEach>
					<%--       <li><a href="${load.id}/articledetail">${load.title}</a></li> --%>
					<%--       <li><a href="${loadarticle.id}/articledetail">${loadarticle.title}</a></li> --%>
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