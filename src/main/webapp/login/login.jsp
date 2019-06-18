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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
    <script>
    	$(document).ready(function(){
    		//문서로딩이 완료되고나서 실행되는 부분
    		//rememberme checkbox
    		//1. rememberme cookie가 있는지? 잇으면 값이 true인지
    		//1-1. rememberme가 true이면 input id="rememberme" 체크박스를 체크
    /* 		var rememberme = Cookies.get("rememberme")//getCookie("rememberme");
    		if(rememberme == "true"){
    			$("#rememberme").prop("checked", true);
    			$("#userId").val(Cookies.get("userId"));
    			$("#password").focus();
    		} */
    		
    		//signin버튼이 클릭시 실행되는 핸들러
    		$("#signinBtn").on("click", function(){
    			console.log("signinBtn click");
    			//로그인 요청을 서버로 전송
    			$("#frm").submit();
    		});
    	});
    </script>
  </head>

  <body>

    <div class="container">

      <form id="frm" class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="userId" class="sr-only">userId</label>
        <input type="text" id="userId" name="userId" value="${param.userId}" class="form-control" placeholder="userId" required>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" name="password" value="brown1234"class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input id="rememberme" name="rememberme" type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button id="signinBtn" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>