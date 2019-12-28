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

  const Product = function(productId, episodeNo) {
    this.getProductApi(productId, episodeNo);
  };

  Product.prototype = {
    getProductApi: function(productId, episodeNo) {
      sendAjax(
        "http://localhost:8080/platform/api/detail/" +
          productId +
          "/" +
          episodeNo +
          "/0"
      );
    },

    setProductData(productData) {
      addTemplate(
        document.querySelector("#productInfo"),
        document.querySelector(".comicInfo"),
        productData
      );

      document.querySelector(".tit_area .view h3").innerHTML =
        productData.episodeName;
    }
  };

  const Comment = function() {};

  Comment.prototype = {
    registerEvent: function() {
      const commentBtn = document.querySelector(".u_cbox_btn_upload");
      commentBtn.addEventListener("click", Comment.prototype.clickCommentBtn);
    },

    setCommentData: function(commentData) {
      addTemplate(
        document.querySelector("#commentList"),
        document.querySelector(".u_cbox_list"),
        commentData
      );

      document.querySelector(".u_cbox_count").innerHTML =
        commentData.commentCount;
    }
  };

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

  const CommentUpDownBtn = function() {
    this.registerEvent();
  };

  CommentUpDownBtn.prototype = {
    registerEvent: function() {
      const commentUpDownBtns = document.querySelectorAll(
        ".u_cbox_recomm_set a"
      );
      commentUpDownBtns.forEach(function(btn) {
        btn.addEventListener(
          "click",
          CommentUpDownBtn.prototype.clickUpDownBtn
        );
      });
    },

    clickUpDownBtn: function() {
      const targetLi = this.parentNode.parentNode.parentNode.parentNode;
      const targetCount = this.children[1];
      const commentId = targetLi.getAttribute("comment-id");

      let targetType = "";
      if (this.className.indexOf("unrecomm") != -1) {
        targetType = "down";
      } else {
        targetType = "up";
      }

      CommentUpDownBtn.prototype.sendUpDownBtn(
        targetType,
        commentId,
        targetCount
      );
    },

    sendUpDownBtn: function(targetType, commentId, targetCount) {
      let oReq = new XMLHttpRequest();

      oReq.addEventListener("load", function() {
        const jsonData = JSON.parse(oReq.responseText);
        if (oReq.status === 200) {
          CommentUpDownBtn.prototype.refreshCommentOne(
            targetType,
            targetCount,
            jsonData
          );
        } else if (oReq.status !== 200) {
          alert(jsonData.message);
        }
      });

      oReq.open(
        "POST",
        "http://localhost:8080/platform/api/comments/" +
          commentId +
          "/" +
          targetType
      );
      oReq.send();
    },

    refreshCommentOne: function(targetType, targetCount, commentData) {
      if (targetType === "up") {
        targetCount.innerHTML = commentData.data.upCount;
        if (commentData.data.up === true) {
          ClassName.prototype.addClass(targetCount.parentNode, "on");
        } else {
          ClassName.prototype.removeClass(targetCount.parentNode, "on");
        }
      } else if (targetType === "down") {
        targetCount.innerHTML = commentData.data.downCount;
        if (commentData.data.down === true) {
          ClassName.prototype.addClass(targetCount.parentNode, "on");
        } else {
          ClassName.prototype.removeClass(targetCount.parentNode, "on");
        }
      }
    }
  };

  const setApiData = function(jsonData) {
    Product.prototype.setProductData(jsonData);
    Comment.prototype.setCommentData(jsonData);
  };

  const sendAjax = function(url, currentPage) {
    let oReq = new XMLHttpRequest();

    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);
      setApiData(jsonData);

      new CommentUpDownBtn();
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

  function initJS() {
    const productId = getParameterByName("productId");
    const episodeNo =
      getParameterByName("no") === "" ? "1" : getParameterByName("no");

    new Product(productId, episodeNo);
    new Comment();
  }

  initJS();
});
