document.addEventListener("DOMContentLoaded", function() {
  const PRODUCT_PER_PAGE = 6;
  const PRODUCT_DEFAULT_START = 0;
  const DEFAULT_CATEGORY = 1;
  const DEFAULT_VIEW_TYPE = "date";

  let startProductIndex = PRODUCT_DEFAULT_START;
  let categoryId = DEFAULT_CATEGORY;
  let viewType = DEFAULT_VIEW_TYPE;

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

  const Category = function() {
    this.registerEvent();
    this.getCategoryApi();
  };

  Category.prototype = {
    categoryTab: document.querySelector(".categories-group"),

    registerEvent: function() {
      Category.prototype.categoryTab.addEventListener(
        "click",
        Category.prototype.clickTabBtn
      );
    },

    clickTabBtn: function() {
      if (event.target.tagName == "UL" || event.target.tagName == "LI") return;

      Product.prototype.setInitSetting();

      Category.prototype.getCategoryId();
      ViewTypeBtn.prototype.initViewColor();
    },

    getCategoryApi: function() {
      sendAjax("./api/categories");
    },

    setCategoryData: function(categoryData) {
      addTemplate(
        document.querySelector("#categoryList"),
        document.querySelector(".categories-group"),
        categoryData
      );
    },

    getCategoryId: function() {
      categoryId = event.target.getAttribute("category-id");

      new Product(categoryId, DEFAULT_VIEW_TYPE, PRODUCT_DEFAULT_START);
      Category.prototype.changeCategoryColor(event.target);
    },

    changeCategoryColor: function(clickedTag) {
      const categories = document.querySelectorAll(
        ".categories-group .btn-category"
      );

      //전체 카테고리 on 클래스 제거
      categories.forEach(function(category) {
        ClassName.prototype.removeClass(category, "on");
      });

      //클릭한 카테고리에만 on 클래스 추가
      ClassName.prototype.addClass(clickedTag.parentNode, "on");
    }
  };

  const Product = function(categoryId, viewType, start) {
    this.getProductApi(categoryId, viewType, start);
  };

  Product.prototype = {
    getProductApi: function(categoryId, viewType, start) {
      sendAjax(
        "./api/products/" +
          viewType +
          "?categoryId=" +
          categoryId +
          "&start=" +
          start,
        start
      );
    },

    setProductData: function(productData, start) {
      //카테고리 탭 바뀌면 상품목록 초기화
      if (start === PRODUCT_DEFAULT_START) Product.prototype.initProductData();

      Product.prototype.setProductTotalCount(productData);

      addTemplate(
        document.querySelector("#productList"),
        document.querySelector(".list-products"),
        productData
      );

      const itemCount = productData.items.length;

      // 가져온 데이터가 4개 미만 OR 아이템 리스트 = 총 개수가 되면 더보기버튼 사라짐
      if (
        itemCount < PRODUCT_PER_PAGE ||
        document.querySelectorAll(".list-products").length ===
          productData.totalCount
      ) {
        MoreBtn.prototype.hideMoreBtn();
      }
    },

    setProductTotalCount: function(productData) {
      document.querySelector(".view_type .sub_tit").innerHTML =
        "총 " + productData.totalCount;
    },

    initProductData: function() {
      document.querySelector(".list-products").innerHTML = "";
    },

    setInitSetting: function() {
      //더보기 버튼 보이게
      MoreBtn.prototype.showMoreBtn();

      //startNum 초기화
      startProductIndex = PRODUCT_DEFAULT_START;
    }
  };

  const ViewTypeBtn = function() {
    this.registerEvent();
  };

  ViewTypeBtn.prototype = {
    viewTab: document.querySelector(".view_type .sortby"),

    registerEvent: function() {
      ViewTypeBtn.prototype.viewTab.addEventListener(
        "click",
        ViewTypeBtn.prototype.clickViewTab
      );
    },

    clickViewTab: function() {
      if (event.target.tagName == "LI" || event.target.tagName == "UL") return;

      Product.prototype.setInitSetting();

      let clickedTag = event.target.parentNode;
      if (event.target.tagName == "A") clickedTag = event.target;

      ViewTypeBtn.prototype.getViewType(clickedTag);
    },

    getViewType: function(clickedTag) {
      viewType = clickedTag.getAttribute("id");

      new Product(categoryId, viewType, PRODUCT_DEFAULT_START);
      ViewTypeBtn.prototype.changeViewColor(clickedTag);
    },

    changeViewColor: function(clickedTag) {
      const views = document.querySelectorAll(".sortby li");

      //전체 카테고리 sel 클래스 제거
      views.forEach(function(view) {
        ClassName.prototype.removeClass(view, "sel");
      });

      //클릭한 카테고리에만 sel 클래스 추가
      ClassName.prototype.addClass(clickedTag.parentNode, "sel");
    },

    initViewColor: function() {
      const views = document.querySelectorAll(".sortby li");
      views.forEach(function(view) {
        ClassName.prototype.removeClass(view, "sel");
      });
      ClassName.prototype.addClass(views[0], "sel");
    }
  };

  const MoreBtn = function() {
    this.registerEvent();
  };

  MoreBtn.prototype = {
    moreBtn: document.querySelector(".more .btn"),

    registerEvent: function() {
      MoreBtn.prototype.moreBtn.addEventListener(
        "click",
        MoreBtn.prototype.clickMoreBtn
      );
    },

    clickMoreBtn: function() {
      //더보기 버튼 누를 때마다 startProductIndex +6
      startProductIndex += PRODUCT_PER_PAGE;

      new Product(categoryId, viewType, startProductIndex);
    },

    hideMoreBtn: function() {
      ClassName.prototype.addClass(MoreBtn.prototype.moreBtn, "hide");
    },

    showMoreBtn: function() {
      ClassName.prototype.removeClass(MoreBtn.prototype.moreBtn, "hide");
    }
  };

  const setApiData = function(jsonData, url, start) {
    //url 주소로 구분
    if (url.indexOf("products") != -1) {
      Product.prototype.setProductData(jsonData, start);
      new MoreBtn();
    } else if (url.indexOf("categories") != -1) {
      Category.prototype.setCategoryData(jsonData);
    }
  };

  const sendAjax = function(url, start) {
    let oReq = new XMLHttpRequest();

    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);
      setApiData(jsonData, url, start);
    });

    oReq.open("GET", url);
    oReq.send();
  };

  function initJS() {
    new Product(DEFAULT_CATEGORY, DEFAULT_VIEW_TYPE, PRODUCT_DEFAULT_START);
    new Category();
    new ViewTypeBtn();
  }

  initJS();
});
