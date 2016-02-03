<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Album Detail</title>
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
					href="http://localhost:8080/SpringMVC_Blog/album">Album</a>
			</h2>
			<div class="template">
				<h3>
				   <p>
					My album
					<!--           <a href="#"  class="more"></a> More -->
					</p>
				</h3>
			</div>
			<div class="container">
				<!-- Codrops top bar -->
				<section id="dg-container" class="dg-container">
					<div class="dg-wrapper">
						<a href="#"><img
							src="<%=request.getContextPath()%>${albumdetail.photo}"
							width="480px" height="260" /></a>
					</div>
					<div style="text-align: center;">
						<a
							href="http://localhost:8080/SpringMVC_Blog/${albumdetail.albumid - 1}/albumdetail">Previous
							Photo</a> &nbsp;&nbsp;&nbsp;&nbsp;<a
							href="http://localhost:8080/SpringMVC_Blog/${albumdetail.albumid +1}/albumdetail">Next
							Photo</a>
					</div>
				</section>
			</div>

			<div class="template">
				<h3>
				<p>
					<span>New Comments</span>
					</p>
				</h3>
				<ul class="pl_n">
					<c:forEach items="${albumreply}" var="u">
						<dl>
							<dt>
								<img src="<%=request.getContextPath()%>/Resources/images/002.jpg">
							</dt>
							<dt></dt>
							<dd>${u.messagename}
								<time>${u.mdate}</time>
							</dd>
							<dd>
								<a href="#">${u.messagecontent}</a>
							</dd>
							<dd> Reply: ${u.messagereply} </dd>
						</dl>
					</c:forEach>
				</ul>
				<h3>
					<p>
						<span>Leave a Comment</span>
					</p>
				</h3>
				<sf:form method="post" modelAttribute="message">
					<table>
						<tr>
							<td><span>Your Name:</span>
							<sf:input path="messagename" /><sf:errors path="messagename"/></td>
						</tr>
						<tr>
							<td><span>Message:</span>
							<sf:input path="messagecontent" /><sf:errors path="messagecontent"/></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Leave comment" />
							</td>
						</tr>
					</table>
				</sf:form>
			</div>
		</article>

		<aside>
			<%@ include file="information.jsp"%>
			<div class="rnav">
				<ul>
					<li class="rnav1 "><a
						href="http://localhost:8080/SpringMVC_Blog/albumme">Me</a></li>
					<li class="rnav2 "><a
						href="http://localhost:8080/SpringMVC_Blog/albumcool">Cool</a></li>
					<li class="rnav3 "><a
						href="http://localhost:8080/SpringMVC_Blog/albumbeauty">Beauty</a></li>
					<li class="rnav4 "><a
						href="http://localhost:8080/SpringMVC_Blog/albumsea">Sea</a></li>
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
	</div>
</body>
</html>