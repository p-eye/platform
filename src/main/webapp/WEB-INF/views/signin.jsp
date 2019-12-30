<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>EYE NEWS - SIGN IN</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="./css/style.css" />
  </head>
  <body>
    <nav class="navbar nav-global navbar-expand-sm">
      <div class="container">
        <a class="navbar-brand" href="./">
          EYETOON
        </a>
      </div>
    </nav>
    <div class="container container-sm container-center">
      <form
        class="form-center"
        action="./signin"
        method="post"
      >
        <h5 class="form-headline">로그인</h5>
        <div class="form-group">
          <input
            type="text"
            class="form-control"
            id="memberId"
            name="memberId"
            placeholder="아이디"
          />
          <span class="error_message" id="idMsg" style="display: none;"
            >필수 정보입니다</span
          >
        </div>
        <div class="form-group">
          <input
            type="password"
            class="form-control"
            id="memberPw"
            name="memberPw"
            placeholder="비밀번호"
          />
          <span class="error_message" id="pwMsg" style="display: none;"
            >필수 정보입니다</span
          >
        </div>
          <span class="error_message" id="loginMsg">${errorMsg}</span>        
        <button class="btn btn-block btn-primary">로그인 하기</button>
        <a href="./signup" class="btn btn-block btn-light">계정 만들기</a>
      </form>
    </div>

    <script src="./js/signin.js"></script>
  </body>
</html>
