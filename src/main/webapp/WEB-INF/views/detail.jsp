<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>EYETOON - DETAIL</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css" href="./css/style.css" />
</head>
<body>
	<nav class="navbar nav-global navbar-expand-sm">
		<div class="container">
			<a class="navbar-brand" href="./"> EYETOON </a>
		</div>
	</nav>
	<div class="container container-sm container-detail">
		<div class="comicInfo"></div>
		<div class="tit_area">
			<div class="view">
				<h3>에피소드 제목</h3>
				<div class="btn_area">
					<span class="pre"> <a href="#">이전화</a>
					</span> <span class="bar">|</span> <span class="next"> <a href="#">다음화</a>
					</span>
				</div>
			</div>
			<div class="vote_lst">
				<dl class="lt">
					<dt>회별별점</dt>
					<dd class="total">
						<div class="rating_type4" id="topTotalStarPoint">
							<span class="star"><em style="width: 100%">평점</em></span> <span
								id="topPointTotalNumber"><strong>0</strong></span> <span
								class="pointTotalPerson">(참여 <em>0</em>)
							</span>
						</div>
					</dd>
					<dt id="topStarLabel">별점주기</dt>
					<dd id="topStarSelectbox">
						<div class="pointSelect fl">
							<a href="javascript:;" class="default" id="starScoreMenu_1"><span
								class="star_type4"><span
									id="topTargetMask" class="mask" style="width: 100%;"><img
										src="./img/ico_star_n.gif" width="60" height="12" alt="점수선택"
										class="starscore_star_pic" /></span></span></a>
							<ul style="display: none;" id="pointSelectOption">
								<li><a href="javascript:;" id="topStar10Select" title="10점"
									value="10"><span class="star_type4"><span
											class="mask" style="width: 100%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="10점" />10점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar9Select" title="9점"
									value="9"><span class="star_type4"><span
											class="mask" style="width: 90%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="9점" />9점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar8Select" title="8점"
									value="8"><span class="star_type4"><span
											class="mask" style="width: 80%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="8점" />8점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar7Select" title="7점"
									value="7"><span class="star_type4"><span
											class="mask" style="width: 70%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="7점" />7점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar6Select" title="6점"
									value="6"><span class="star_type4"><span
											class="mask" style="width: 60%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="6점" />6점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar5Select" title="5점"
									value="5"><span class="star_type4"><span
											class="mask" style="width: 50%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="5점" />5점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar4Select" title="4점"
									value="4"><span class="star_type4"><span
											class="mask" style="width: 40%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="4점" />4점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar3Select" title="3점"
									value="3"><span class="star_type4"><span
											class="mask" style="width: 30%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="3점" />3점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar2Select" title="2점"
									value="2"><span class="star_type4"><span
											class="mask" style="width: 20%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="2점" />2점</span></span></a>
								</li>
								<li><a href="javascript:;" id="topStar1Select" title="1점"
									value="1"><span class="star_type4"><span
											class="mask" style="width: 10%"><img
												src="./img/ico_star_n.gif" width="60" height="12" alt="1점" />1점</span></span></a>
								</li>
							</ul>
						</div>
						<a href="#" class="btn_bx fl" id="topStarScoreSubmitButton"><span>확인</span></a>
					</dd>
					<dd id="topStarText" class="txt" style="display: none;">
						<span>참여하셨습니다.</span>
					</dd>
				</dl>
				<dl class="rt">
					<dt>등록일</dt>
					<dd class="date">2000.00.00</dd>
				</dl>
			</div>

			<div class="view_area " id="comic_view_area">
				<!-- 뷰어  -->
				<div class="wt_viewer" style="background: #FFFFFF">
					<img
						src="https://image-comic.pstatic.net/webtoon/737835/2/20191220191859_ba6348fc96d4018cf477c3eb36b55c26_IMAG01_1.jpg"
						title="" alt="comic content" id="content_image_0" />
				</div>
				<!-- //뷰어 -->

				<div class="btn_w">
					<!-- 좋아요 -->
					<!-- //좋아요 -->
				</div>
			</div>
		</div>
		<div class="section_cont">
			<div id="cbox_module" class="u_cbox">
				<div class="u_cbox_wrap u_cbox_ko u_cbox_type_sort_best">
					<div class="u_cbox_head">
						<h5 class="u_cbox_title">댓글</h5>
						<span class="u_cbox_count">0</span>
						<button type="button" class="u_cbox_btn_refresh">
							<span>새로고침</span>
						</button>
					</div>
					<div class="u_cbox_write_wrap">
						<div class="u_cbox_write_box">
							<form class="form">
								<div class="u_cbox_write">
									<div class="u_cbox_write_area">
										<textarea id="cbox_module__write_textarea"
											name="commentContent" class="u_cbox_text" rows="3" cols="30"></textarea>
									</div>
									<div class="u_cbox_write_count">
										<strong class="u_cbox_count_num">0</strong>/<span
											class="u_cbox_write_total">500</span>
									</div>
									<div class="u_cbox_upload">
										<button type="button" class="u_cbox_btn_upload">
											<span class="u_cbox_txt_upload">등록</span>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="u_cbox_sort">
						<div class="u_cbox_sort_option">
							<ul class="u_cbox_sort_option_list">
								<li class="u_cbox_sort_option_wrap u_cbox_sort_option_on">
									<a href="#" class="u_cbox_select"> <span
										class="u_cbox_sort_label">BEST댓글</span>
								</a>
								</li>
								<li class="u_cbox_sort_option_wrap"><a href="#"
									class="u_cbox_select"> <span class="u_cbox_sort_label">전체댓글</span>
								</a></li>
							</ul>
						</div>
						<div class="u_cbox_head_tools"></div>
					</div>
					<div class="u_cbox_content_wrap">
						<ul class="u_cbox_list"></ul>
					</div>
					<div class="u_cbox_paginate" style="display: block;">
						<div class="u_cbox_page_wrap"></div>
					</div>
					<div class="u_cbox_view_comment">
						<a href="#" class="u_cbox_btn_view_comment"
							data-action="view#link" data-log="RPC.allmore">
							<span class="u_cbox_in_view_comment">전체 댓글 더보기</span> <span
							class="u_cbox_ico_view_comment"></span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="./js/detail.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js"></script>
	<script type="rv-template" id="productInfo">
      <div class="thumb">
        <img
          src="https://dnvefa72aowie.cloudfront.net/origin/article/201910/bab41be88724554f4d20444c5402e5c672058eda54e0fd15fca4adee6365aa29.webp?q=95&s=1440x1440&t=inside"
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
	<script type="rv-template" id="commentList">
        {{#each commentList}}
        <li class="u_cbox_comment" comment-id={{commentId}}>
        <div class="u_cbox_comment_box">
          <div class="u_cbox_area">
            <div class="u_cbox_info">
                <span class="u_cbox_id">{{commentWriter}}</span>
                  <span
                    class="u_cbox_date"
                    >{{createDate}}</span
                  >
            </div>
            <div class="u_cbox_text_wrap">
              <span class="u_cbox_ico_best">BEST</span>
              <span class="u_cbox_contents" data-lang="ko"
                >{{comment}}</span
              >
            </div>

              <div class="u_cbox_recomm_set">
                <a href="javascirpt:;" class="u_cbox_btn_recomm{{#if up}} on{{/if}}">
                  <span class="u_cbox_ico_recomm">좋아요</span>
                  <em class="u_cbox_cnt_recomm">{{upCount}}</em>
                </a>
                <a href="javascirpt:;" class="u_cbox_btn_unrecomm{{#if down}} on{{/if}}">
                  <span class="u_cbox_ico_unrecomm">싫어요</span>
                  <em class="u_cbox_cnt_unrecomm">{{downCount}}</em>
                </a>
              </div>
          </div>
        </div>
      </li>
      {{/each}}
    </script>
	<script type="rv-template" id="commentPage">
      <a href="javascript:;" class="u_cbox_pre_end" title="첫 페이지 목록으로 이동하기">
        <span class="u_cbox_cnt_page">처음</span></a>
        <a href="javascript:;" class="u_cbox_pre" title="이전 페이지 목록으로 이동하기">
        <span class="u_cbox_cnt_page">이전</span></a>
        {{#times 1 5}}
        <a href="javascript:;" class="u_cbox_page u_box_num_page" page={{this}}><span class="u_cbox_num_page">{{this}}</span></a>
        {{/times}}
        <a href="javascript:;" class="u_cbox_next" title="다음 페이지 목록으로 이동하기">
        <span class="u_cbox_cnt_page">다음</span></a>
        <a href="javascript:;" class="u_cbox_next_end" title="마지막 페이지 목록으로 이동하기">
        <span class="u_cbox_cnt_page">끝</span></span></a>
    </script>
</body>
</html>
