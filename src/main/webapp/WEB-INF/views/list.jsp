<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>EYETOON - LIST</title>
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
    <div class="container container-sm container-detail">
      <div class="comicInfo"></div>
      <table class="table table-hover viewList">
        <thead>
          <tr>
            <th scope="col">이미지</th>
            <th scope="col">제목</th>
            <th scope="col">별점</th>
            <th scope="col">등록일</th>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
      <div class="paginate">
        <div class="page_wrap justify-content-center">
          <a
            href="/webtoon/list.nhn?titleId=641253&amp;page=12"
            class="pre"
            title="이전 페이지 목록으로 이동"
            ><span class="cnt_page">이전</span></a
          >
          <div class="pagination pageNumList"></div>
          <a
            href="/webtoon/list.nhn?titleId=641253&amp;page=14"
            class="next"
            title="다음 페이지 목록으로 이동"
            ><span class="cnt_page">다음</span></a
          >
        </div>
      </div>
    </div>
    <script src="./js/list.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js"></script>
    <script type="rv-template" id="productInfo">
      <div class="thumb">
        <img
          src="./{{productImageUrl}}"
          title={{title}}
          alt={{title}}
          height="150"
        />
      </div>
      <div class="detail">
        <h4 class="product-title">{{title}}</h4>
        <h6 class="product-content">{{content}}</h6>
      </div>
    </script>
    <script type="rv-template" id="episodeList">
      {{#each episodes}}
      <tr>
        <td>
          <a
            href="./detail?productId={{productId}}&no={{episodeNo}}"
          >
            <img
              src="https://shared-comic.pstatic.net/thumb/webtoon/733082/7/thumbnail_202x120_cf9a03b5-60ac-45a6-a977-0b51dd5a6d2f.jpg"
              title={{episodeName}}
              alt={{episodeName}}
              width="71"
              height="41"
              onerror="this.src='https://static-comic.pstatic.net/staticImages/COMICWEB/NAVER/img/common/non71_41.gif'"
            />
            <span class="mask"></span>
          </a>
        </td>
        <td class="title">
          <a
          href="./detail.html?productId={{productId}}&no={{episodeNo}}""
            >{{episodeName}}</a
          >
        </td>
        <td>
          <div class="rating_type">
            <span class="star"><em style="width:98.92%">평점</em></span>
            <strong>{{starScore}}</strong>
          </div>
        </td>
        <td class="num">{{createDate}}</td>
      </tr>
      {{/each}}
    </script>
    <script type="rv-template" id="pageList">
        <a href="./list?productId=1253&page=9" class="page page-item"
        ><em class="num_page">9</em></a
      >
    </script>
  </body>
</html>
