<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pg:pager maxPageItems="5" items="${param.items }" export="curPage=pageNumber" url="${param.url }">
<c:forEach items="${param.items }" var="p">
	<pg:param name="${p}"/>
</c:forEach>
<pg:last>
All have ${param.items} items, ${pageNumber } pages,
</pg:last>
Now is ${curPage } page
<pg:first>
	<a href="${pageUrl }">Home page</a>
</pg:first>
<pg:prev>
	<a href="${pageUrl }">Previous page</a>
</pg:prev>
<pg:pages>

<c:if test="${curPage eq pageNumber }">
	[${pageNumber }]
</c:if>
<c:if test="${curPage ne pageNumber }">
	<a href="${pageUrl }">${pageNumber }</a>
</c:if>
</pg:pages>
<pg:next>
	<a href="${pageUrl }">Next page</a>
</pg:next>
<pg:last>
	<a href="${pageUrl }">Last page</a>
</pg:last>
</pg:pager>