<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>EYE NEWS - SIGNUP</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="./css/style.css" />
  </head>
  <body>
    <nav class="navbar nav-global nav-global-center navbar-expand-sm">
      <div class="container d-flex justify-content-center">
        <a class="navbar-brand" href="./main.html">
          EYE NEWS
        </a>
      </div>
    </nav>

    <div class="container container-sm container-center">
      <form class="form-center">
        <h5 class="form-headline">가입하기</h5>

        <div class="form-group">
          <label class="control-label" for="memberId">
            <span>아이디</span>
          </label>
          <input
            type="text"
            class="form-control"
            id="memberId"
            name="memberId"
            placeholder="5~20자의 영문 소문자, 숫자, 특수기호(_),(-)"
          />
          <span class="error_message" id="idMsg" style="display: none;"
            >필수 정보입니다</span
          >
        </div>
        <div class="form-group">
          <label class="control-label" for="memberPw">
            <span>비밀번호</span>
          </label>
          <input
            type="password"
            class="form-control"
            id="memberPw"
            name="memberPw"
            placeholder="8~16자의 영문, 숫자 조합"
          />
          <span class="error_message" id="pwMsg" style="display: none;"
            >필수 정보입니다</span
          >
        </div>

        <div class="form-group">
          <label class="control-label" for="memberName">
            <span>이름</span>
          </label>
          <input
            type="text"
            class="form-control"
            id="memberName"
            name="memberName"
            placeholder="2~4자의 한글"
          />
          <span class="error_message" id="nameMsg" style="display: none;"
            >필수 정보입니다</span
          >
        </div>
        <div class="form-group">
          <label class="control-label" for="memberGender">
            <span>성별</span>
          </label>
          <div class="form-check form-check-inline">
            <input
              type="radio"
              class="form-check-input"
              id="memberGender1"
              name="memberGender"
              value="M"
            />
            <label class="form-check-label" for="memberGender1">남성</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              type="radio"
              class="form-check-input"
              id="memberGender2"
              name="memberGender"
              value="F"
            />
            <label class="form-check-label" for="memberGender2">여성</label>
          </div>
          <span class="error_message" id="genderMsg" style="display: none;"
            >필수 정보입니다</span
          >
        </div>
        <div class="form-group">
          <label class="control-label" for="memberPhone">
            <span>전화번호</span>
          </label>
          <input
            type="text"
            class="form-control"
            id="memberPhone"
            name="memberPhone"
            placeholder="010-0000-0000"
          />
          <span class="error_message" id="phoneMsg" style="display: none;"
            >필수 정보입니다</span
          >
        </div>
        <div class="form-group">
          <label class="control-label" for="memberBirthday">
            <span>생년월일</span>
          </label>
          <input
            type="date"
            class="form-control"
            id="memberBirthday"
            name="memberBirthday"
          />
          <span class="error_message" id="birthdayMsg" style="display: none;"
            >필수 정보입니다</span
          >
        </div>

        <button class="btn btn-block btn-primary">가입하기</button>
        <a href="./signinForm" class="btn btn-block btn-light">로그인</a>
      </form>
    </div>
    <script src="./js/signup.js"></script>
  </body>
</html>
