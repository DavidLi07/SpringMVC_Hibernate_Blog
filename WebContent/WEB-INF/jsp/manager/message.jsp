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
    <h2 class="about_h">You now as:<a href="http://localhost:8080/SpringMVC_Blog/manager/index">Index</a>>><a href="http://localhost:8080/SpringMVC_Blog/manager/message">Message</a></h2>
    <div class="template">
      
      <h3>
      <p>
          <span>New Message</span></p>
      </h3>
      				<c:if test="${messagelist.total le 0 }">
					<tr>
						<td colspan="6">No Data Now</td>
					</tr>
				</c:if>
				<c:if test="${messagelist.total gt 0}">
				  <ul class="pl_n">
					<c:forEach items="${messagelist.datas}" var="message">
					    <dl>
							<dt>
<%-- 								<img src="<%=request.getContextPath()%>${message.messagephoto}"> --%>
								<img src="<%=request.getContextPath()%>/Resources/images/008.jpg">
							</dt>
							<dt></dt>
         <dd>${message.messagename}
            <time>${message.mdate}</time>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="${message.messageid}/messagedelete">Delete</a>
          </dd>
          <dd><a href="#">${message.messagecontent }</a></dd>
          <dd> Reply: ${message.messagereply}  <a href = "${message.messageid}/messagereply">Reply</a></dd>
        </dl>
						<h3>
							<a href="#" target="_blank" class="more"></a>
						</h3>
					</c:forEach>
					</ul>
					<td colspan="20" align="center"><jsp:include
							page="/Pager/pager.jsp">
							<jsp:param value="message" name="url" />
							<jsp:param value="${messagelist.total }" name="items" />
						</jsp:include></td>
				</c:if>
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
  <!-- 清除浮动 --> 
</div>
</body>
</html>