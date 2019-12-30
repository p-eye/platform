document.addEventListener("DOMContentLoaded", function() {
  const addTemplate = function(rawTemplate, templateBox, templateData) {
    const bindTemplate = Handlebars.compile(rawTemplate.innerHTML);
    templateBox.innerHTML += bindTemplate(templateData);
  };

  const ProductCategory = function() {};

  ProductCategory.prototype = {
    setProductApi: function(productData) {
      addTemplate(
        document.querySelector("#productList"),
        document.querySelector(".form-control"),
        productData
      );
    }
  };

  const CommentImage = function() {
    this.registerFileEvent();
  };

  CommentImage.prototype = {
    thumbnailFile: document.querySelector("#episodeThumbnail"),

    registerFileEvent: function() {
      CommentImage.prototype.thumbnailFile.addEventListener(
        "change",
        CommentImage.prototype.checkFileType
      );
    },

    checkFileType: function() {
      const uploadedFile = event.target.files[0];
      console.log(uploadedFile.name);
      document.querySelector(".upload-name.episode-thumbnail").value =
        uploadedFile.name;
      if (!CommentImage.prototype.validImageType(uploadedFile)) {
        console.warn("invalid image file type");
        return;
      }

      const imgThumb = document.querySelector(".item_thumb");
      imgThumb.src = window.URL.createObjectURL(uploadedFile);
    },

    validImageType: function(image) {
      const result =
        ["image/jpeg", "image/png", "image/jpg"].indexOf(image.type) > -1;
      return result;
    },

    test7: function() {
      uploadedFile = CommentImage.prototype.uploadedFile;

      CommentImage.prototype.uploadedFile.reset();
      uploadedFile.value == "";

      console.log(uploadedFile.files[0]);
      //      console.log(files[0]);
      //    files[0].select();
      //  document.selection.clear;
    }
  };

  const SubmitBtn = function() {
    this.registerEvent();
  };

  SubmitBtn.prototype = {
    registerEvent: function() {
      const submitBtn = document.querySelector(".btn-submit");
      console.log("test");
      submitBtn.addEventListener("click", SubmitBtn.prototype.clickSubmitBtn);
    },

    clickSubmitBtn: function() {
      event.preventDefault();

      SubmitBtn.prototype.createEpisodeFormData();
    },

    createEpisodeFormData: function() {
      const episodeFormData = new FormData(
        document.querySelector("#uploadForm")
      );

      SubmitBtn.prototype.sendEpisodeForm(episodeFormData);
    },

    sendEpisodeForm: function(episodeFormData) {
        document.querySelector("#uploadForm").submit();
    	/*
      let oReq = new XMLHttpRequest();
      oReq.open("POST", "http://localhost:8080/platform/upload");
      oReq.addEventListener("load", function() {});

      oReq.send(episodeFormData);
      */
    }
  };

  const sendAjax = function(url) {
    let oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
      const jsonData = JSON.parse(oReq.responseText);

      ProductCategory.prototype.setProductApi(jsonData);
    });

    oReq.open("GET", url);
    oReq.send();
  };

  function initJS() {
    sendAjax("http://localhost:8080/platform/api/products/" + "작가1");
    new SubmitBtn();
    new CommentImage();
  }

  initJS();
});
