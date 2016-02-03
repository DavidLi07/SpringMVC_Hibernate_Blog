<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article</title>
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
    <h2 class="about_h">You now as:<a href="http://localhost:8080/SpringMVC_Blog/manager/index">Index</a>>><a href="http://localhost:8080/SpringMVC_Blog/manager/article">Article</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://localhost:8080/SpringMVC_Blog/manager/addarticle">Add Article</a></h2>
  <div class="bloglist">
        <c:forEach items="${type}" var="article">
      <div class="newblog">
        <ul>
          <h3><a href="${article.id}/articledetail">${article.title}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${article.id }/articleedit">Edit</a>&nbsp;&nbsp;<a href="${article.id}/articledelete">Delete</a></h3>
          <p class="autor"><span>Author:${article.author}</span>
	        <span>Type:${article.type}</span><span><a href="${article.id}/articledetail">Comment</a></span>
	       </p>          
          <div class="content" style="width:100%">${article.content}</div><a href="${article.id}/articledetail">Get whole</a>
        </ul>
         <figure> <img src="<%=request.getContextPath()%>${article.photo}"></figure>
        <div class="dateview">${article.bdate}</div>
      </div>
    </c:forEach>
    </div>
  </article>

 <aside>
    <%@ include file="information.jsp" %>
       <div class="rnav">
       <ul>
      <li class="rnav1 "><a href="http://localhost:8080/SpringMVC_Blog/manager/dairy">Dairy</a></li>
      <li class="rnav2 "><a href="http://localhost:8080/SpringMVC_Blog/manager/life">Life</a></li>
      <li class="rnav3 "><a href="http://localhost:8080/SpringMVC_Blog/manager/weather">Weather</a></li>
      <li class="rnav4 "><a href="http://localhost:8080/SpringMVC_Blog/manager/mood">Mood</a></li>
      </ul>
    </div>
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