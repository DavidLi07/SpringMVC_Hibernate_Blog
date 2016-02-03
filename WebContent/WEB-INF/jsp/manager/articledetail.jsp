<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article details</title>
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
			<%@ include file="managernavi.jsp"%>
		</header>

		<article>
			<h2 class="about_h">
				You now as:<a
					href="http://localhost:8080/SpringMVC_Blog/manager/index">Index</a>>><a
					href="articledetail">Article details</a> <a
					href="http://localhost:8080/SpringMVC_Blog/manager/addarticle">Add
					Article</a>
			</h2>

			<!-- <table width="700" align="center" border="1"> -->
			<!-- 	<tr> -->
			<%-- 	<td>Article ID:</td><td>${articledetail.id }</td> --%>
			<!-- 	</tr> -->
			<!-- 	<tr> -->
			<%-- 	<td>Title:</td><td>${articledetail.title}</td> --%>
			<!-- 	</tr> -->
			<!-- 	<tr> -->
			<%-- 	<td>Content:</td><td>${articledetail.content }</td> --%>
			<!-- 	</tr> -->
			<!-- 	<tr> -->
			<%-- 	<td>Type:</td><td>${articledetail.type }</td> --%>
			<!-- 	</tr> -->
			<!-- 	<tr> -->
			<%-- 	<td>Comments:</td><td>${articledetail.message }</td> --%>
			<!-- 	</tr> -->
			<!-- </table>     -->
			<div class="index_about">
				<h2 class="c_titile"><a href="articleedit">${articledetail.title}</a></h2>
				<p class="box_c">
					<span class="d_time">Date: ${articledetail.bdate}</span><span>Author:
						${articledetail.author}</span>
				</p>
				<ul class="infos">
					<li>${articledetail.content}</li>
				</ul>
				      <div class="dg-wrapper">
<!-- 						<a href="#"><img -->
<%-- 							src="${articledetail.photo}" --%>
<!-- 							width="480px" height="260" /></a> -->
						<a href="#"><img
							src="<%=request.getContextPath()%>${articledetail.photo}"
							width="480px" height="280" /></a>
					</div>
				<div class="nextinfo">
					<p>
						<a
							href="http://localhost:8080/SpringMVC_Blog/manager/${articledetail.preid}/articledetail">Previous
							article</a>
					</p>
					<p>
						<a
							href="http://localhost:8080/SpringMVC_Blog/manager/${articledetail.nextid}/articledetail">Next
							article</a>
					</p>
				</div>
			</div>

			<div class="template">
				<h3>
					<p>
						<span>New Comments</span>
					</p>
				</h3>
				<ul class="pl_n">
					<c:forEach items="${articlereply}" var="articlereply">
						<dl>
							<dt>
								<img src="<%=request.getContextPath()%>/Resources/images/006.jpg">
							</dt>
							<dt></dt>
							<dd>${articlereply.messagename}
								<time>${articlereply.mdate}</time>
								&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="${articlereply.messageid}/articlereplydelete">Delete</a>
							</dd>
							<dd>
								<a href="#">${articlereply.messagecontent}</a>
							</dd>
							<dd>
								Reply: ${articlereply.messagereply} <a
									href="${articlereply.messageid}/articlereplyreply">Reply</a>
							</dd>
						</dl>
					</c:forEach>
				</ul>

				<!-- 	     <h3> -->
				<!--         <p><span>Leave a Comment</span></p> -->
				<!--       </h3> -->
				<%--       <sf:form method = "post" modelAttribute="comment"> --%>
				<!--       		<table> -->
				<!--       			<tr> -->
				<%--       				<td><span>Your Name:</span><sf:input path="messagename"/></td> --%>
				<!--       			</tr> -->
				<!--       			<tr> -->
				<%-- 	    			<td><span>Message:</span><sf:input path ="messagecontent"/></td>    			 --%>
				<!--     			</tr> -->
				<!--     				<tr> -->
				<!-- 	                <td colspan="2"> -->
				<!-- 	                <input type="submit" value="Leave comment"/> -->
				<!--     </td> -->
				<!-- 	</tr> -->
				<!--       		</table> -->
				<%--       		</sf:form> --%>
			</div>
		</article>

		<aside>
			<%@ include file="information.jsp"%>
			<div class="rnav">
				<ul>
					<li class="rnav1 "><a
						href="http://localhost:8080/SpringMVC_Blog/manager/dairy">Dairy</a></li>
					<li class="rnav2 "><a
						href="http://localhost:8080/SpringMVC_Blog/manager/life">Life</a></li>
					<li class="rnav3 "><a
						href="http://localhost:8080/SpringMVC_Blog/manager/weather">Weather</a></li>
					<li class="rnav4 "><a
						href="http://localhost:8080/SpringMVC_Blog/manager/mood">Mood</a></li>
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
			<%@ include file="../copyright.jsp"%>
		</aside>
		<div class="clear"></div>
	</div>
</body>
</html>