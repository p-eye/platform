document.addEventListener("DOMContentLoaded", function() {
  let pageRangeIndex = 0;
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

  Handlebars.registerHelper("times", function(from, to, block) {
    var accum = "";
    for (var i = from; i <= to; i++) accum += block.fn(i);
    return accum;
  });

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
    episodeId: "",

    initCommentList: function() {
      const commentList = document.querySelectorAll(
        ".u_cbox_list .u_cbox_comment"
      );

      commentList.forEach(function(comment) {
        comment.parentNode.removeChild(comment);
      });
    },

    setCommentData: function(commentData) {
      addTemplate(
        document.querySelector("#commentList"),
        document.querySelector(".u_cbox_list"),
        commentData
      );

      document.querySelector(".u_cbox_count").innerHTML =
        commentData.commentCount;

      Comment.prototype.episodeId = commentData.episodeId;
      Comment.prototype.registerEvent();
    },

    registerEvent: function() {
      const commentBtn = document.querySelector(".u_cbox_btn_upload");
      commentBtn.addEventListener("click", Comment.prototype.clickCommentBtn);
    },

    clickCommentBtn() {
      const commentFormData = new FormData(document.querySelector(".form"));
      let oReq = new XMLHttpRequest();
      oReq.open(
        "POST",
        "http://localhost:8080/platform/api/comments/" +
          Comment.prototype.episodeId
      );

      oReq.addEventListener("load", function() {
        const jsonData = JSON.parse(oReq.responseText);
        if (oReq.status === 200) {
          document.querySelector("textarea").value = "";
          Comment.prototype.refreshCommentList(jsonData.result);
        } else if (oReq.status !== 200) {
          alert("Request failed.  Returned status of " + oReq.status);
        }
      });

      oReq.send(commentFormData);
    },

    refreshCommentList(commentData) {
      console.log(commentData);
      Comment.prototype.initCommentList();

      addTemplate(
        document.querySelector("#commentList"),
        document.querySelector(".u_cbox_list"),
        commentData
      );

      document.querySelector(".u_cbox_count").innerHTML =
        commentData.commentCount;

      new CommentUpDownBtn();
    }
  };

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
        targetCount.innerHTML = commentData.result.comment.upCount;
        if (commentData.result.comment.up === true) {
          ClassName.prototype.addClass(targetCount.parentNode, "on");
        } else {
          ClassName.prototype.removeClass(targetCount.parentNode, "on");
        }
      } else if (targetType === "down") {
        targetCount.innerHTML = commentData.result.comment.downCount;
        if (commentData.result.comment.down === true) {
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
    new CommentUpDownBtn();
    new CommentPage(jsonData);
  };

  const sendAjax = function(url) {
    let oReq = new XMLHttpRequest();

    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);
      setApiData(jsonData);
    });

    oReq.open("GET", url);
    oReq.send();
  };

  const CommentPage = function(pageData) {
    this.setEndPageData(pageData);
    this.setPageList();
  };

  CommentPage.prototype = {
    pageRange: 5,
    commentPerPage: 5,
    currentPage: 1,
    pageColumn: 0,
    endPage: 0,
    endColumn: 0,

    setEndPageData: function(pageData) {
      const totalCount = pageData.commentCount;
      CommentPage.prototype.endPage = Math.ceil(
        totalCount / CommentPage.prototype.commentPerPage
      );

      CommentPage.prototype.endColumn =
        Math.ceil(
          CommentPage.prototype.endPage / CommentPage.prototype.pageRange
        ) - 1;
    },

    /* 페이지 리스트 초기화 */
    initPageList: function() {
      const pageList = document.querySelectorAll(".u_cbox_page_wrap a");

      pageList.forEach(function(page) {
        page.parentNode.removeChild(page);
      });
    },

    /* 페이지 템플릿 초기화 */
    initPageTemplate: function(fromIndex, toIndex) {
      if (parseInt(CommentPage.prototype.endPage) <= parseInt(toIndex))
        toIndex = CommentPage.prototype.endPage;

      document.querySelector("#commentPage").innerHTML = document
        .querySelector("#commentPage")
        .innerHTML.replace(
          /times\s\d{0,}\s\d{0,}/,
          "times " + fromIndex + " " + toIndex
        );
    },

    setPageList: function() {
      CommentPage.prototype.initPageList();

      const fromIndex =
        CommentPage.prototype.pageRange * CommentPage.prototype.pageColumn + 1;

      const toIndex =
        CommentPage.prototype.pageRange *
        (CommentPage.prototype.pageColumn + 1);

      CommentPage.prototype.initPageTemplate(fromIndex, toIndex);

      addTemplate(
        document.querySelector("#commentPage"),
        document.querySelector(".u_cbox_page_wrap"),
        ""
      );

      CommentPage.prototype.setFirstPageBtn();
      CommentPage.prototype.setLastPageBtn();
      CommentPage.prototype.setPrevPageBtn();
      CommentPage.prototype.setNextPageBtn();
      CommentPage.prototype.setNumberPageBtn();
    },

    setFirstPageBtn: function() {
      const firstPage = document.querySelector("a.u_cbox_pre_end");
      firstPage.setAttribute("page", 1);

      if (CommentPage.prototype.currentPage == 1) {
        firstPage.setAttribute("style", "display: none;");
      }

      firstPage.addEventListener(
        "click",
        CommentPage.prototype.clickFirstPageBtn
      );
    },

    clickFirstPageBtn: function() {
      const commentPage = this.getAttribute("page");

      CommentPage.prototype.currentPage = commentPage;

      CommentPage.prototype.sendCurrentPage(commentPage);
      CommentPage.prototype.pageColumn = 0;
      CommentPage.prototype.setPageList();

      CommentPage.prototype.colorFirstPage(this);
    },

    colorFirstPage: function() {
      const pageList = document.querySelectorAll(
        ".u_cbox_page_wrap a.u_cbox_page"
      );

      pageList.forEach(function(page, index) {
        ClassName.prototype.removeClass(page, "on");
        if (index === 0) {
          ClassName.prototype.addClass(page, "on");
        }
      });
    },

    toggleFirstPageBtn() {
      const firstPage = document.querySelector("a.u_cbox_pre_end");
      if (CommentPage.prototype.currentPage == 1) {
        firstPage.setAttribute("style", "display: none;");
      } else {
        firstPage.removeAttribute("style");
      }
    },

    setLastPageBtn: function() {
      const lastPage = document.querySelector("a.u_cbox_next_end");
      lastPage.setAttribute("page", CommentPage.prototype.endPage);

      if (CommentPage.prototype.currentPage == CommentPage.prototype.endPage) {
        lastPage.setAttribute("style", "display: none;");
      }

      lastPage.addEventListener(
        "click",
        CommentPage.prototype.clickLastPageBtn
      );
    },

    clickLastPageBtn: function() {
      const commentPage = this.getAttribute("page");
      CommentPage.prototype.currentPage = commentPage;

      CommentPage.prototype.sendCurrentPage(commentPage);
      CommentPage.prototype.pageColumn = CommentPage.prototype.endColumn;
      CommentPage.prototype.setPageList();
      CommentPage.prototype.colorLastPage(this);
    },

    colorLastPage: function() {
      const pageList = document.querySelectorAll(
        ".u_cbox_page_wrap a.u_cbox_page"
      );

      pageList.forEach(function(page, index) {
        ClassName.prototype.removeClass(page, "on");
        if (index === pageList.length - 1) {
          ClassName.prototype.addClass(page, "on");
        }
      });
    },

    toggleLastPageBtn() {
      const lastPage = document.querySelector("a.u_cbox_next_end");
      if (CommentPage.prototype.currentPage == CommentPage.prototype.endPage) {
        lastPage.setAttribute("style", "display: none;");
      } else {
        lastPage.removeAttribute("style");
      }
    },

    setPrevPageBtn: function() {
      /*이전페이지*/
      const prevPage = document.querySelector("a.u_cbox_pre");

      if (CommentPage.prototype.pageColumn === 0) {
        prevPage.setAttribute("style", "display: none;");
      }

      prevPage.addEventListener(
        "click",
        CommentPage.prototype.clickPrevNextPage
      );
    },

    setNextPageBtn: function() {
      /* 다음페이지*/
      const nextPage = document.querySelector("a.u_cbox_next");

      if (
        CommentPage.prototype.pageColumn === CommentPage.prototype.endColumn
      ) {
        nextPage.setAttribute("style", "display: none;");
      }

      nextPage.addEventListener(
        "click",
        CommentPage.prototype.clickPrevNextPage
      );
    },

    clickPrevNextPage: function() {
      if (this.className.indexOf("pre") != -1) {
        CommentPage.prototype.pageColumn -= 1;
      } else CommentPage.prototype.pageColumn += 1;

      CommentPage.prototype.sendCurrentPage(
        CommentPage.prototype.pageRange * CommentPage.prototype.pageColumn + 1
      );
      CommentPage.prototype.setPageList();
    },

    setNumberPageBtn: function() {
      /*숫자 페이지*/
      const pageNumList = document.querySelectorAll("a.u_box_num_page");

      pageNumList.forEach(function(page) {
        page.addEventListener("click", CommentPage.prototype.clickNumberPage);
      });
    },

    clickNumberPage: function() {
      const commentPage = this.getAttribute("page");
      CommentPage.prototype.currentPage = commentPage;

      CommentPage.prototype.colorCurrentPage(this);
      CommentPage.prototype.sendCurrentPage(commentPage);

      CommentPage.prototype.toggleFirstPageBtn();
      CommentPage.prototype.toggleLastPageBtn();
    },

    sendCurrentPage: function(commentPage) {
      let oReq = new XMLHttpRequest();

      oReq.addEventListener("load", function() {
        const jsonData = JSON.parse(oReq.responseText);
        refreshCommentList(jsonData);
        new CommentUpDownBtn();
      });

      oReq.open(
        "GET",
        "http://localhost:8080/platform/api/comments/94/" + commentPage
      );
      oReq.send();
    },

    colorCurrentPage: function(targetAnchor) {
      console.log(targetAnchor);

      const pageList = document.querySelectorAll(
        ".u_cbox_page_wrap a.u_cbox_page"
      );

      pageList.forEach(function(page, index) {
        ClassName.prototype.removeClass(page, "on");
        if (targetAnchor === page) {
          ClassName.prototype.addClass(page, "on");
        }
      });
    }
  };

  function refreshCommentList(commentData) {
    Comment.prototype.initCommentList();

    addTemplate(
      document.querySelector("#commentList"),
      document.querySelector(".u_cbox_list"),
      commentData.result
    );
  }

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
