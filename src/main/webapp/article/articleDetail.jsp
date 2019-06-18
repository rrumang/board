<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>사용자리스트</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>
<style>
	#img{
		width : 200px;
		height : 200px;
	}
</style>
<script>
	$(document).ready(function(){
		$("#modifyBtn").on("click", function(){
			var articleId = $("#articleId2").val();
			$("#articleId").val(articleId);
			$("#modifyFrm").submit();
		});
		$("#deleteBtn").on("click", function(){
			var articleId = $("#articleId2").val();
			var boardId = $("#boardId").val();
			$("#articleId3").val(articleId);
			$("#boardId2").val(boardId);
			$("#deleteFrm").submit();
		});
		$("#replyBtn").on("click",function(){
			var articleId = $("#articleId2").val();
			var content = $("#content2").val();
			$("#articleId4").val(articleId);
			$("#content").val(content);
			$("#addFrm").submit();
		});
		$("#answerBtn").on("click",function(){
			var parentId = $("#articleId2").val();
			var article_group = $("#article_group").val();
			var boardId = $("#boardId").val();
			$("#parentId2").val(parentId);
			$("#article_group2").val(article_group);
			$("#boardId3").val(boardId);
			$("#add2Frm").submit();
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
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						
						<form action="${pageContext.request.contextPath }/articleAdd2" id="add2Frm">
							<input type="hidden" id="parentId2" name="parentId2"/>
							<input type="hidden" id="article_group2" name="article_group2"/>
							<input type="hidden" id="boardId3" name="boardId3"/>
						</form>
						
						<form action="${pageContext.request.contextPath }/articleModify" id="modifyFrm">
							<input type="hidden" id="articleId" name="articleId"/>
						</form>
						
						<form action="${pageContext.request.contextPath }/articleDelete" id="deleteFrm">
							<input type="hidden" id="articleId3" name="articleId3"/>
							<input type="hidden" id="boardId2" name="boardId2"/>
						</form>

						<form action="${pageContext.request.contextPath }/replyAdd" id="addFrm">
							<input type="hidden" id="content" name="content"/>
							<input type="hidden" id="articleId4" name="articleId4"/>
							<input type="hidden" id="userId" name="userId" value="${userId }"/>
						</form>
						
						<form class="form-horizontal" role="form">

							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<label id="userId2" class="control-label">${vo.title}</label>
									<input type="hidden" id="articleId2" name="articleId2" value="${vo.articleId }"/>
									<input type="hidden" id="boardId" name="boardId" value="${vo.boardId}"/>
									<input type="hidden" id="parentId" name="parentId" value="${vo.parentId}"/>
									<input type="hidden" id="article_group" name="article_group" value="${vo.article_group}"/>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-10">
									<td rows="10" cols="50" style="width: 766px; height: 412px;" readonly>${vo.content }</td>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
								<div class="col-sm-10">
								<c:forEach items="${fileList }" var="file" varStatus="status">
									<a href="${pageContext.request.contextPath}/fileDownload?fileId=${file.fileId}">${file.fileName}</a><br>
								</c:forEach>
									<button id="modifyBtn" type="button" class="btn btn-default">수정</button>
									<button id="deleteBtn" type="button" class="btn btn-default">삭제</button>
									<button id="answerBtn" type="button" class="btn btn-default">답글</button>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">댓글</label>
								<div class="col-sm-10">
									<c:forEach items="${replyList }" var="reply" varStatus="status">
									<c:choose>
										<c:when test="${reply.reply_use == 'y' }">
											<c:choose>
												<c:when test="${reply.userId == userId }">
													<tr class="replyTr">
														<td>${reply.content } [ ${reply.userId } / <fmt:formatDate value="${reply.add_dt}" pattern="yyyy-MM-dd" /> ]<a href="${pageContext.request.contextPath}/replyDelete?replyId=${reply.replyId}&articleId=${reply.articleId}">&nbsp;X</a></td><br>
													</tr>
												</c:when>
												<c:otherwise>
													<tr class="replyTr">
														<td>${reply.content } [${reply.userId } / ${reply.add_dt }]</td><br>
													</tr>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<tr class="replyTr">
												<td>삭제된 댓글입니다</td><br>
											</tr>
										</c:otherwise>
									</c:choose>
									</c:forEach>
									<input id="content2" name="content2" type="text"  maxlength="10">
									<button type="button" id="replyBtn" class="btn btn-default">댓글저장</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>