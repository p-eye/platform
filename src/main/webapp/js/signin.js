document.addEventListener("DOMContentLoaded", function() {
  const MsgToggle = function() {};

  MsgToggle.prototype = {
    showMsg: function(element, msg) {
      element.innerHTML = msg;
      element.setAttribute("style", "display: block;");
    },

    hideMsg: function(element) {
      element.innerHTML = "";
      element.setAttribute("style", "display: none;");
    }
  };

  const LoginInput = function() {};

  LoginInput.prototype = {
    inputList: document.querySelectorAll("form input"),
    messageList: document.querySelectorAll(".error_message"),

    initAllMsg: function() {
      LoginInput.prototype.messageList.forEach(function(msgSpan) {
        MsgToggle.prototype.hideMsg(msgSpan);
      });
    },

    isAllInputFilled: function() {
      LoginInput.prototype.initAllMsg();

      const inputFilledArray = Array.from(LoginInput.prototype.inputList).map(
        function(input) {
          return LoginInput.prototype.isEachInputFilled(input);
        }
      );

      const isInputFilledArray = inputFilledArray.every(function(element) {
        return element == true;
      });

      return isInputFilledArray;
    },
    isEachInputFilled: function(memberInput) {
      const msgSpan = memberInput.nextElementSibling;
      if (memberInput.value === "") {
        MsgToggle.prototype.showMsg(msgSpan, "필수 정보입니다");
        return false;
      } else {
        MsgToggle.prototype.hideMsg(msgSpan);
        return true;
      }
    }
  };

  const LoginBtn = function() {
    this.registerEvent();
  };

  LoginBtn.prototype = {
    loginBtn: document.querySelector(".btn.btn-block.btn-primary"),

    registerEvent: function() {
      LoginBtn.prototype.loginBtn.addEventListener(
        "click",
        LoginBtn.prototype.clickLoginBtn
      );
    },

    clickLoginBtn: function() {
      event.preventDefault();
      event.stopPropagation();

      if (!LoginInput.prototype.isAllInputFilled()) return false;

      const loginForm = document.querySelector("form");
      loginForm.submit();
    }
  };

  function initJS() {
    new LoginBtn();
  }

  initJS();
});
