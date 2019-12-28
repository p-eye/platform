document.addEventListener("DOMContentLoaded", function() {
  const ClassName = function() {};

  ClassName.prototype = {
    addClass: function(element, classString) {
      element.className = element.className
        .split(" ")
        .filter(function(name) {
          return name !== classString;
        })
        .concat(classString)
        .join(" ");
    },

    removeClass: function(element, classString) {
      element.className = element.className
        .split(" ")
        .filter(function(name) {
          return name !== classString;
        })
        .join(" ");
    }
  };

  const addTemplate = function(rawTemplate, templateBox, templateData) {
    const bindTemplate = Handlebars.compile(rawTemplate.innerHTML);
    templateBox.innerHTML += bindTemplate(templateData);
  };

  const sendAjax = function(url, currentPage) {
    let oReq = new XMLHttpRequest();

    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);
      console.log(jsonData);
      addTemplate(
        document.querySelector("#productInfo"),
        document.querySelector(".comicInfo"),
        jsonData
      );

      addTemplate(
        document.querySelector("#commentList"),
        document.querySelector(".u_cbox_list"),
        jsonData
      );

      document.querySelector(".tit_area .view h3").innerHTML =
        jsonData.episodeName;
      document.querySelector(".u_cbox_count").innerHTML = jsonData.commentCount;

      const commentUpList = document.querySelectorAll(".u_cbox_btn_recomm");
      commentUpList.forEach(function(btn) {
        btn.addEventListener("click", clickUpBtn);
      });

      const commentdownList = document.querySelectorAll(".u_cbox_btn_unrecomm");
      commentdownList.forEach(function(btn) {
        btn.addEventListener("click", clickDownBtn);
      });
    });

    oReq.open("GET", url);
    oReq.send();
  };

  function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)");
    var results = regex.exec(location.search);

    const parameterValue =
      results === null
        ? ""
        : decodeURIComponent(results[1].replace(/\+/g, " "));

    return parameterValue;
  }

  function clickCommentBtn() {
    console.log("test");
    const myForm = document.querySelector(".u_cbox_write_wrap form");
    console.log(myForm);

    var object = {};
    new FormData(myForm).forEach(function(value, key) {
      object[key] = value;
    });
    var json = JSON.stringify(object);
    console.log(json);
  }

  function initJS() {
    const productId = getParameterByName("productId");
    const episodeNo =
      getParameterByName("no") === "" ? "1" : getParameterByName("no");

    sendAjax(
      "http://localhost:8080/platform/api/detail/" +
        productId +
        "/" +
        episodeNo +
        "/0"
    );

    const commentBtn = document.querySelector(".u_cbox_btn_upload");
    commentBtn.addEventListener("click", clickCommentBtn);
  }

  function clickUpBtn() {
    let targetEl = "";
    if (event.target.tagName === "A") {
      targetEl = event.target.parentNode.parentNode.parentNode.parentNode;
    } else {
      targetEl =
        event.target.parentNode.parentNode.parentNode.parentNode.parentNode;
    }

    const commentId = targetEl.getAttribute("comment-id");

    console.log(commentId);

    let oReq = new XMLHttpRequest();

    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);
      console.log(jsonData);
    });

    oReq.open(
      "POST",
      "http://localhost:8080/platform/api/comments/" + commentId + "/up"
    );
    oReq.send();
  }

  function clickDownBtn() {
    let targetEl = "";
    if (event.target.tagName === "A") {
      targetEl = event.target.parentNode.parentNode.parentNode.parentNode;
    } else {
      targetEl =
        event.target.parentNode.parentNode.parentNode.parentNode.parentNode;
    }

    const commentId = targetEl.getAttribute("comment-id");

    console.log(commentId);

    let oReq = new XMLHttpRequest();

    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);
      consoe.log(jsonData);
    });

    oReq.open(
      "POST",
      "http://localhost:8080/platform/api/comments/" + commentId + "/down"
    );
    oReq.send();
  }

  initJS();
});
