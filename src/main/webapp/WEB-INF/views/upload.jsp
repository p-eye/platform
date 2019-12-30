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
    <link rel="stylesheet" type="text/css" href="css/style.css" />
  </head>
  <body>
    <nav class="navbar nav-global navbar-expand-sm">
      <div class="container">
        <a class="navbar-brand" href="./">
          EYETOON
        </a>
      </div>
    </nav>

    <div class="container container-sm container-item-create">
      <h5 class="container-headline">에피소드 등록</h5>

      <form
        class="form-item-create"
        method="post"
        action=""
        id="uploadForm"
        enctype="multipart/form-data"
      >
        <div class="form-group form-picture">
          <div class="file-box">
            <input
              class="upload-name episode-thumbnail"
              value="대표 이미지"
              disabled="disabled"
            />

            <label for="episodeThumbnail" class="btn btn-secondary"
              >업로드</label
            >
            <input
              type="file"
              class="upload-hidden"
              id="episodeThumbnail"
              name="episodeThumbnail"
              accept="image/png, image/jpeg"
              multiple
            />

            <img
              src=""
              height="40"
              alt=""
              class="item_thumb episodeThumbnail"
            />
          </div>
        </div>

        <div class="form-group form-category">
          <select id="productsCategory" name="productId" class="form-control">
            <option name="productId" value="" disabled selected
              >작품을 선택해주세요.</option
            >
          </select>
        </div>

        <div class="form-group form-title">
          <input
            type="text"
            class="form-control"
            id="episodeName"
            name="episodeName"
            placeholder="에피소드 제목"
          />
        </div>

        <div class="form-group form-description">
          <textarea
            class="form-control"
            id="productsDescription"
            name="description"
            rows="10"
            placeholder="제품 설명을 작성해주세요."
          ></textarea>
        </div>

        <label for="episodeContent" class="btn btn-secondary">업로드</label>
        <input
          type="file"
          accept="image/png, image/jpeg"
          multiple
          id="episodeContent"
          name="episodeContent"
        />

        <!--
        <div class="file-box">
          <input class="upload-name" value="내용" disabled="disabled" />

          <label for="episodeContent" class="btn btn-secondary">업로드</label>
          <input
            type="file"
            class="upload-hidden"
            id="episodeContent"
            name="episodeContent"
            accept="image/png, image/jpeg"
            multiple
          />
        </div>-->
        <!--
        <div class="review_potos review_photos_write">
          <div class="item_preview_thumbs">
            <ul class="lst_thumb">
              <li class="item">
                <a href="#" class="anchor">
                  <span class="spr_book ico_del">삭제</span>
                </a>
                <img src="" width="100" alt="" class="item_thumb" />
                <span class="img_border"></span>
              </li>
            </ul>
          </div>
        </div>
-->
        <button class="btn btn-primary btn-submit">에피소드 등록하기</button>
      </form>
    </div>

    <script src="./js/upload.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js"></script>
    <script type="rv-template" id="productList">
      {{#each items}}
      <option name="product" value={{productId}}>{{title}}</option>
      {{/each}}
    </script>
  </body>
</html>
