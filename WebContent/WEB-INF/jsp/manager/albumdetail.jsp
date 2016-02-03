<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Album</title>
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
    <h2 class="about_h">You now as:<a href="http://localhost:8080/SpringMVC_Blog/manager/index">Index</a>>>
    <a href="http://localhost:8080/SpringMVC_Blog/manager/album">Album</a></h2>
     
			<div class="template">
				<h3>
					My album &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="addphoto">Add Photo</a>
					<!--           <a href="#"  class="more"></a> More -->
				</h3>
			</div>
            <a href="albumdetail">${albumdetail.album}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${albumdetail.albumid }/photoedit">Edit</a>&nbsp;&nbsp;<a href="${albumdetail.albumid }/photodelete">Delete</a>
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
							href="http://localhost:8080/SpringMVC_Blog/manager/${albumdetail.albumid - 1}/albumdetail">Previous
							Photo</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="http://localhost:8080/SpringMVC_Blog/manager/${albumdetail.albumid +1}/albumdetail">Next
							Photo</a>
					</div>
				</section>
			</div>

         <div class="template">
			<h3>
				<p><span>New Comments</span></p>
			</h3>
			<ul class="pl_n">
				<c:forEach items="${albumreply}" var="album1">
					<dl>
						<dt>
							<img src="<%=request.getContextPath()%>/Resources/images/002.jpg">
						</dt>
						<dt></dt>
						<dd>${album1.messagename}
							<time>${album1.mdate}</time>
							     &nbsp;&nbsp;&nbsp;&nbsp;<a
									href="${album1.messageid}/photoreplydelete">Delete</a>
						</dd>
						<dd>
							<a href="#">${album1.messagecontent}</a>
						</dd>
							<dd>
								Reply: ${album1.messagereply} <a
									href="${album1.messageid}/photoreplyreply">Reply</a>
							</dd>
					</dl>
				</c:forEach>
			</ul>
			
      		</div>
  </article>
  
 <aside>
    <%@ include file="information.jsp" %>
           <div class="rnav">
           <ul>
      <li class="rnav1 "><a href="http://localhost:8080/SpringMVC_Blog/manager/albumme">Me</a></li>
      <li class="rnav2 "><a href="http://localhost:8080/SpringMVC_Blog/manager/albumcool">Cool</a></li>
      <li class="rnav3 "><a href="http://localhost:8080/SpringMVC_Blog/manager/albumbeauty">Beauty</a></li>
      <li class="rnav4 "><a href="http://localhost:8080/SpringMVC_Blog/manager/albumsea">Sea</a></li>
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
</div>
</body>
</html>