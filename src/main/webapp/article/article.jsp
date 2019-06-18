<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>
<style>
	.articleTr:hover{
		cursor : pointer;
	}
</style>
<script>
	$(document).ready(function(){
		$(".articleTr").on("click",function(){
			var articleId = $(this).find(".articleId").text();
			$("#articleId").val(articleId);
			$("#form").submit();
		});
	});
</script>
</head>
<body>
	<!-- header -->
	<%@include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left영역 -->
			<%@include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${board.name }</h2>
						
						<form action="${pageContext.request.contextPath }/articleDetail?boardId=${board.boardId}" id="form">
							<input type="hidden" id="articleId" name="articleId"/>
						</form>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글번호</th>
									<th>제목</th>
									<th>작성자아이디</th>
									<th>작성일시</th>
								</tr>
								<!--향상된 포문 -->
								<c:forEach items="${articleList }" var="article" varStatus="status">
									<c:choose>
									<c:when test="${article.title != '삭제된 글입니다' }">
									<tr class="articleTr">
										<td class="articleId">${article.articleId }</td>
										<td><c:forEach begin="1" end="${article.lv-1}" step="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach><c:if test="${article.lv != 1}">&rarr;</c:if>&nbsp;${article.title }</td>
										<td>${article.userId }</td>
										<td><fmt:formatDate value="${article.add_dt}" pattern="yyyy-MM-dd" /></td>
									</tr>
									</c:when>
									<c:otherwise>
									<tr>
										<td class="articleId">${article.articleId }</td>
										<td><c:forEach begin="1" end="${article.lv-1}" step="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach><c:if test="${article.lv != 1}">&rarr;</c:if>&nbsp;${article.title }</td>
										<td>${article.userId }</td>
										<td><fmt:formatDate value="${article.add_dt}" pattern="yyyy-MM-dd" /></td>
									</tr>
									</c:otherwise>
									</c:choose>
								</c:forEach>
							</table>
						</div>

						<a href="${pageContext.request.contextPath }/articleAdd?boardId=${board.boardId}" class="btn btn-default pull-right">새글 등록</a>
						<!-- 사용자수 : 105건
							 페이지네이션 : 11건
						 -->
						<div class="text-center">
							<ul class="pagination">
 								<c:choose>
									<c:when test="${pageVo.page == 1 }">
										<li class="disabled"><span>««</span></li>
									</c:when>
									<c:otherwise>
										<li>
										<a href="${pageContext.request.contextPath}/goBoard?boardId=${board.boardId}&page=1&pageSize=${pageVo.pageSize}">««</a>
										</li>
									</c:otherwise>
								</c:choose>
 								<c:choose>
									<c:when test="${pageVo.page == 1 }">
										<li class="disabled"><span>«</span></li>
									</c:when>
									<c:otherwise>
										<li>
										<a href="${pageContext.request.contextPath}/goBoard?boardId=${board.boardId}&page=${pageVo.page -1}&pageSize=${pageVo.pageSize}">«</a>
										</li>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="1" end="${paginationSize }" step="1" var="i">
									<c:choose>
										<c:when test="${pageVo.page == i }">
											<li class="active"><span>${i }</span></li>
										</c:when>
									<c:otherwise>
										<li>
											<a href="${pageContext.request.contextPath}/goBoard?boardId=${board.boardId}&page=${i }&pageSize=${pageVo.pageSize }">${i }</a>
										</li>
									</c:otherwise>
									</c:choose>
								</c:forEach>
			 						<c:choose>
									<c:when test="${pageVo.page == paginationSize }">
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>
										<li>
										<a href="${pageContext.request.contextPath}/goBoard?boardId=${board.boardId}&page=${pageVo.page +1}&pageSize=${pageVo.pageSize}">»</a>
										</li>
									</c:otherwise>
								</c:choose>
			 					<c:choose>
									<c:when test="${pageVo.page == paginationSize }">
										<li class="disabled"><span>»»</span></li>
									</c:when>
									<c:otherwise>
										<li>
										<a href="${pageContext.request.contextPath}/goBoard?boardId=${board.boardId}&page=${paginationSize}&pageSize=${pageVo.pageSize}">»»</a>
										</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>