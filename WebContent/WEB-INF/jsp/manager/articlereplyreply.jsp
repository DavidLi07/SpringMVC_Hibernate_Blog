<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message</title>
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
    <h2 class="about_h">You now as:<a href="http://localhost:8080/SpringMVC_Blog/manager/index">Index</a>>><a href="http://localhost:8080/SpringMVC_Blog/manager/article">Article</a></h2>
    <div class="template">
      
      <h2>
          New Message
      </h2>
      <ul class="pl_n">
       <sf:form method="post" modelAttribute="articlereplyreply">
        <dl>
<%--           <dt><img src="<%=request.getContextPath()%>${articlereplyreply.messagephoto}"> --%>
           <dt>
          <img src="<%=request.getContextPath()%>/Resources/images/006.jpg"></dt>
          <dt> </dt>
          <dd>${articlereplyreply.messagename}
            <time>${articlereplyreply.mdate}</time>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="${articlereplyreply.messageid}/messagedelete">Delete</a>
          </dd>
          <dd><a href="#">${articlereplyreply.messagecontent }</a></dd>
          <dd> Reply: <sf:input path="messagereply"/><input type="submit" value="Reply"/></dd>
        </dl>
         <h3>
        <a href="#" target="_blank" class="more"></a>
      </h3>
       </sf:form>
      </ul>

<!--   		<h3> -->
<!--         <p><span>Leave a Message</span></p> -->
<!--         <a href="#" target="_blank" class="more"></a> -->
<!--       </h3> -->
<%--       <sf:form method = "post" modelAttribute="message"> --%>
<!--       		<table> -->
<!-- <!--       		     <tr> -->
<%-- <%--       				<td><span>ID:</span><sf:input path="id"/></td> --%>
<!-- <!--       			</tr> -->
<!--       			<tr> -->
<%--       				<td><span>Your Name:</span><sf:input path="messagename"/></td> --%>
<!--       			</tr> -->
<!--       			<tr> -->
<%-- 	    			<td><span>Message:</span><sf:input path ="messagecontent"/></td>    			 --%>
<!--     			</tr> -->
<!--     				<tr> -->
<!-- 	                <td colspan="2"> -->
<!-- 	                <input type="submit" value="Leave message"/> -->
<!--     </td> -->
<!-- 	</tr> -->
<!--       		</table> -->
<%--       		</sf:form> --%>
     </div>
  </article>
 <aside>
    <%@ include file="information.jsp" %>
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