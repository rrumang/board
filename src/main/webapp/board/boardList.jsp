<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>게시판 생성 및 수정</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>

<script>
	$(document).ready(function(){
		//게시판 생성 버튼 클릭 이벤트 처리
		$("#addBtn").on("click",function(){
			$("#frm").submit();
		});
		
		//게시판 수정 버튼 클릭 이벤트 처리
		$(".boardTr modifyBtn").on("click", function(){
			var boardId = $(this).find(".boardId").text();
			$("#boardId").val(boardId);
			$("#frm2").submit();
			
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
						<h2 class="sub-header">게시판 생성 및 수정</h2>
						
						<form id="frm" action="${pageContext.request.contextPath }/addBoard" method="post">
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">게시판이름</label>
								<div class="col-sm-5">
									<input id="name" type="text" name="name"/>
									<select id="selectBox" name="selectBox">
										<option>사용</option>
										<option>미사용</option>
									</select>
									<button id="addBtn" type="button">생성</button>
								</div>
							</div>
						</form>
						
					</div>
				</div>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">	
						<div class="table-responsive">
							<table class="table table-striped">
									<!--userList의 데이터를 한건씩 조회해서 pageContext.setAttribute("user", vo);  -->
									<c:forEach items="${boardList }" var="board">
										<form action="${pageContext.request.contextPath }/modifyBoard" method="post">
											<tr class="boardTr" data-boardid="${board.boardId }">
												<td>게시판이름</td>
												<td>
													<input type="hidden" id="boardId" name="boardId" value="${board.boardId}"/>
												</td>
												<td>
													<input type="text" id="name "name="name" value="${board.name}"/>
												</td>
												<td>
													<select id="selectBox" name="selectBox">
														<c:choose>
															<c:when test="${board.use_yn == 'y' }">
																	<option selected="true">사용</option>
																	<option>미사용</option>
																</select>
															</c:when>
															<c:otherwise>
																	<option>사용</option>
																	<option selected="true">미사용</option>
															</c:otherwise>
														</c:choose>
													</select>
												</td>
												<td>
													<input id="modifyBtn" type="submit" value="수정"/>
												</td>
											</tr>
										</form>
									</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>