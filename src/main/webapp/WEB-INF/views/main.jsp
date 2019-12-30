<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>EYETOON - MAIN</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css" href="./css/style.css" />
</head>
<body>
	<nav class="navbar nav-global navbar-expand-sm">
		<div class="container">
			<a class="navbar-brand" href="./"> EYETOON </a>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a href="./signinForm" class="btn-member">
						<i class="material-icons">account_box</i>
				</a></li>

				<li class="nav-item"><a href="item_create.html"><i
						class="material-icons ic-create">create</i></a></li>
			</ul>
		</div>
	</nav>

	<div class="container container-main-index">
		<ul class="categories-group tab_gr">
			<!-- [D] 선택된 li에 on 클래스 추가 -->
		</ul>

		<div class="view_type">
			<h2 class="sub_tit">총 0</h2>
			<ul class="sortby">
				<li class="sel"><a href="#" id="date"><span
						class="Ntxt_update">업데이트순</span></a></li>
				<li class=""><a href="#" id="viewCnt"><span
						class="Ntxt_count">조회순</span></a></li>
				<li class=""><a href="#" id="StarScore"><span
						class="Ntxt_star_rate">별점순</span></a></li>
			</ul>
		</div>
		<ul class="list-products row"></ul>
		<div class="more">
			<button class="btn">
				<span>더보기</span>
			</button>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js"></script>
	<script type="rv-template" id="categoryList">
      {{#each items}}
        <li class="btn btn-category{{#if @first}} on{{/if}}">
          <a href="#" category-id={{categoryId}} title={{categoryName}}>{{categoryName}}</a>
        </li>
      {{/each}}
    </script>

	<script type="rv-template" id="productList">
      {{#each items}}
          <li class="list-products-item col-12 col-md-4 col-lg-4">
          <a href="./list?productId={{productId}}">
            <div class="card">
              <div
                class="card-img-top"
                style="background: url('./{{productImageUrl}}') no-repeat center; background-size: cover; height: 200px"
              ></div>
              <div class="card-body">
                <h5 class="title">{{title}}</h5>
                <h6 class="episode">{{episodeName}}</h6>

                <div class="text-muted">
                  <h6 class="writer">{{writer}}</h6>
                  <time datetime="2019-08-20T08:30:00Z">2개월전</time>
                </div>
              </div>
            </div>
          </a>
        </li>
      {{/each}}
    </script>
	<script src="./js/main.js"></script>
</body>
</html>
