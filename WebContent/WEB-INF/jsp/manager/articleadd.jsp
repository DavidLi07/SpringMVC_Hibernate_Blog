<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Article</title>
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
					href="http://localhost:8080/SpringMVC_Blog/manager/article">Article</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="http://localhost:8080/SpringMVC_Blog/manager/addarticle">Add
					Article</a>
			</h2>

			<div class="about">
				<h2 align="center">Add Article</h2>
			</div>
			<sf:form method="post" modelAttribute="userInfo">
				<table width=700 align="center" border="1">
					<!-- 	<tr> -->
					<%-- 	<td>Id:</td><td><sf:input path="id"/></td> --%>
					<!-- 	</tr> -->
					<tr>
						<td>Title:</td>
						<td><sf:input path="title" /> <sf:errors path="title"/></td>
					</tr>
					<tr>
						<td>Author:</td>
						<td><sf:input path="author" /><sf:errors path="author"/></td>
					</tr>
					<tr>
						<td>Type:</td>
						<td>
							<%-- <sf:input path="type" /> --%> 
							<select name="type">
								<option value='Dairy'>Dairy</option>
								<option value='Weather'>Weather</option>
								<option value='Life'>Life</option>
								<option value='Mood'>Mood</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>Articletype:</td>
						<td><select name="username">
								<option value='Common'>Common</option>
								<option value='New'>New</option>
								<option value='Recommend'>Recommend</option>
						</select></td>
						<%-- 						<td><sf:input path="username" /></td> --%>
					</tr>
					<tr>
						<td>Photo:</td>
						<td>
						<%-- <sf:input path="photo" /> --%>
						       <sf:input type="file" path="photo"/>
						</td>
					</tr>
					<tr>
						<td>Content:</td>
						<td  height="100"><sf:input type ="text" size ="60" height="90" path="content" /><sf:errors path="content"/></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add Article" /></td>
					</tr>
				</table>
			</sf:form>

			<!--   <div class="bloglist"> -->

			<%--   <c:if test="${pagers.total le 0 }"> --%>
			<!--      <tr>  -->
			<!-- 	<td colspan="6">No Data Now</td> -->
			<!-- 	</tr> -->
			<%-- 	</c:if> --%>
			<%-- 	<c:if test="${pagers.total gt 0}"> --%>
			<%--     <c:forEach items="${pagers.datas}" var="article"> --%>
			<!--       <div class="newblog"> -->
			<!--         <ul> -->
			<%--           <li><h3><a href="${article.id}/articledetail">${article.title}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${article.id }/articleedit">Edit</a>&nbsp;&nbsp;<a href="${article.id}/articledelete">Delete</a></h3></li> --%>
			<%--           <p class="autor"><span>Author:${article.author}</span> --%>
			<%-- 	        <span>Type:${article.type}</span><span><a href="">Comment</a></span> --%>
			<!-- 	       </p>           -->
			<%--           <div class="content" style="width:100%">${article.content}</div><a href="${article.id }/articledetail">Get whole</a> --%>
			<!--         </ul> -->
			<%--          <figure> <img src="<%=request.getContextPath()%>${article.photo}"></figure> --%>
			<%--         <div class="dateview">${article.bdate}</div> --%>
			<!--       </div> -->
			<%--     </c:forEach> --%>
			<!--         		<td colspan="6"> -->
			<%-- 			<jsp:include page="/Pager/pager.jsp"> --%>
			<%-- 				<jsp:param value="article" name="url"/> --%>
			<%-- 				<jsp:param value="${pagers.total }" name="items"/> --%>
			<%-- 			</jsp:include> --%>
			<!-- 		</td> -->
			<%--     </c:if> --%>
			<!--     </div> -->


		</article>

		<aside>
			<%@ include file="information.jsp"%>
			<div class="rnav">
				<ul>
					<li class="rnav1 "><a href="#">Dairy</a></li>
					<li class="rnav2 "><a href="#">Cool</a></li>
					<li class="rnav3 "><a href="#">Weather</a></li>
					<li class="rnav4 "><a href="#">ssss</a></li>
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
		<!-- 清除浮动 -->
	</div>
</body>
</html>