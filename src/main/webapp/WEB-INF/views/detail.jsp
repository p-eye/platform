<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>EYETOON - DETAIL</title>
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
        <a class="navbar-brand" href="./main">
          EYETOON
        </a>
      </div>
    </nav>
    <div class="container container-sm container-detail">
      <div class="comicInfo"></div>
      <div class="tit_area">
        <div class="view">
          <h3>에피소드 제목</h3>
          <div class="btn_area">
            <span class="pre">
              <a href="#">이전화</a>
            </span>
            <span class="bar">|</span>
            <span class="next">
              <a href="#">다음화</a>
            </span>
          </div>
        </div>
        <div class="vote_lst">
          <dl class="lt">
            <h6>회별별점</h6>
            <dd class="total">
              <div class="rating_type4" id="topTotalStarPoint">
                <span class="star"><em style="width:94%">평점</em></span>
                <span id="topPointTotalNumber"><strong>9.44</strong></span>
                <span class="pointTotalPerson">(참여 <em>11083</em>)</span>
              </div>
            </dd>
            <dt id="topStarLabel">
              <img
                src="https://static-comic.pstatic.net/staticImages/COMICWEB/NAVER/img/detail/txt_point_click.gif"
                width="38"
                height="11"
                class="starscore_guide_txt"
                alt="별점주기"
              />
            </dt>
            <dd id="topStarSelectbox">
              <a
                href="#"
                class="btn_bx fl"
                id="topStarScoreSubmitButton"
                onclick="nclk_v2(event,'bdt.starok');"
                ><span>확인</span></a
              >
            </dd>
            <dd id="topStarText" class="txt" style="display:none;">
              <span>참여하셨습니다.</span>
            </dd>
          </dl>
          <dl class="rt">
            <dt>등록일</dt>
            <dd class="date">2019.12.25</dd>
          </dl>
        </div>

        <div class="view_area " id="comic_view_area">
          <!-- 뷰어  -->
          <div class="wt_viewer" style="background:#FFFFFF">
            <img
              src="https://image-comic.pstatic.net/webtoon/737835/2/20191220191859_ba6348fc96d4018cf477c3eb36b55c26_IMAG01_1.jpg"
              title=""
              alt="comic content"
              id="content_image_0"
            />
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
                      <textarea
                        id="cbox_module__write_textarea"
                        name="commentContent"
                        class="u_cbox_text"
                        rows="3"
                        cols="30"
                      ></textarea>
                    </div>
                    <div class="u_cbox_write_count">
                      <strong class="u_cbox_count_num">0</strong>/<span
                        class="u_cbox_write_total"
                        >500</span
                      >
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
                    <a href="#" class="u_cbox_select">
                      <span class="u_cbox_sort_label">BEST댓글</span>
                    </a>
                  </li>
                  <li class="u_cbox_sort_option_wrap">
                    <a href="#" class="u_cbox_select">
                      <span class="u_cbox_sort_label">전체댓글</span>
                    </a>
                  </li>
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
              <a
                href="#"
                class="u_cbox_btn_view_comment"
                data-action="view#link"
                data-log="RPC.allmore"
              >
                <span class="u_cbox_in_view_comment">전체 댓글 더보기</span>
                <span class="u_cbox_ico_view_comment"></span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="./js/detail.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js"></script>
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


