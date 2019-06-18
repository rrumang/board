<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/addBoard">게시판생성</a></li>
		<c:forEach items="${boardList }" var="board">
			<c:if test="${board.use_yn == 'y' }">
				<li  class="active">
				<a class="boardId" href="${pageContext.request.contextPath}/goBoard?boardId=${board.boardId}">${board.name }</a>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</div>
</body>