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

  function getPageData(pageData, currentPage) {
    console.log(pageData);
    const totalCount = pageData.totalCount;
    const episodePerPage = 5;
    const pageRange = 6;
    const endPage = Math.ceil(totalCount / episodePerPage);
    /*
    addTemplate(
      document.querySelector("#pageList"),
      document.querySelector(".pageNumList"),
      pageData
    );
*/
    setPageList(pageRange, endPage);

    setPageNum(pageRange, currentPage, endPage);

    markCurrentPage(currentPage);
  }

  function setPageList(pageRange, endPage) {
    for (var index = 1; index <= pageRange; index++) {
      const newPageAnchor = document.createElement("a");
      newPageAnchor.setAttribute("class", "page page-item");
      newPageAnchor.setAttribute(
        "href",
        "./list.html?productId=1&page=" + index
      );
      newPageAnchor.innerHTML = index;

      document.querySelector(".pageNumList").appendChild(newPageAnchor);

      if (index === endPage) return;
    }
  }

  function setPageNum(pageRange, currentPage, endPage) {
    const pageRangeHalfFloor = Math.floor(pageRange / 2) + 1;
    const pageRangeHalfCeil = Math.ceil(pageRange / 2);

    /*
    //처음 페이지 설정
    setEachPageLink(document.querySelector(".page_begin_link"), 1);

    //마지막 페이지 설정
    setEachPageLink(document.querySelector(".page_end_link"), endPage);

    //왼쪽으로 페이지 설정. 첫 페이지에서는 왼쪽 누르면 자기 자신
    setEachPageLink(
      document.querySelector(".page_prev_link"),
      currentPage < 2 ? currentPage : parseInt(currentPage) - 1
    );

    // 오른쪽으로 페이지 설정. 마지막 페이지에서는 오른쪽 누르면 자기자신
    setEachPageLink(
      document.querySelector(".page_next_link"),
      currentPage > endPage - 1 ? currentPage : parseInt(currentPage) + 1
    );
*/
    // 넘버 페이지 설정
    const pages = document.querySelectorAll(".page");
    pages.forEach(function(page, index) {
      // 절반 이하 ex) 블록 5개에서 1,2,3 페이지 클릭시 변화 X
      if (currentPage < pageRangeHalfFloor + 1) {
        page.innerHTML = index + 1;
        setEachPageLink(page, index + 1);
        return;
      }
      //마지막 페이지를 넘어가지 않도록 ex) 블록 5개에서 8,9,10 클릭시 동일
      if (currentPage > endPage - pageRangeHalfFloor)
        currentPage = endPage - pageRangeHalfCeil + 1;

      const tempPage = index + parseInt(currentPage) - (pageRangeHalfFloor - 1);
      setEachPageLink(page, tempPage);
      page.innerHTML = tempPage;
    });
  }

  function setEachPageLink(target, currentPage) {
    target.setAttribute("href", "./list.html?productId=1&page=" + currentPage);
  }

  function markCurrentPage(currentPage) {
    const pageNumberList = document.querySelectorAll(".page");

    //url로 소수점, 1 미만 페이지가 들어왔을 때 정수처리
    if (currentPage < 1) currentPage = 1;
    else currentPage = Math.floor(currentPage);

    pageNumberList.forEach(function(anchor) {
      if (currentPage === parseInt(anchor.innerHTML)) {
        ClassName.prototype.addClass(anchor, "on");
        return;
      }
    });
  }

  const sendAjax = function(url, currentPage) {
    let oReq = new XMLHttpRequest();

    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);

      addTemplate(
        document.querySelector("#episodeList"),
        document.querySelector(".viewList tbody"),
        jsonData
      );
      addTemplate(
        document.querySelector("#productInfo"),
        document.querySelector(".comicInfo"),
        jsonData
      );

      getPageData(jsonData, currentPage);
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
    const currentPage =
      getParameterByName("page") === "" ? "1" : getParameterByName("page");

    sendAjax(
      "http://localhost:8080/platform/api/list/" +
        productId +
        "/" +
        currentPage,
      currentPage
    );
  }

  initJS();
});
