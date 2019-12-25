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

  const SignupBtn = function() {
    this.registerEvent();
  };

  SignupBtn.prototype = {
    signupBtn: document.querySelector(".btn.btn-block.btn-primary"),

    registerEvent: function() {
      SignupBtn.prototype.signupBtn.addEventListener("click", function() {
        SignupBtn.prototype.clickSignupBtn();
      });
    },

    clickSignupBtn: function() {
      event.preventDefault();
      event.stopPropagation();

      if (!MemberInput.prototype.isAllInputFilled()) return false;

      SignupBtn.prototype.createMemberObj();
    },

    createMemberObj: function() {
      let memberFormObj = {};

      let inputList = document.querySelectorAll(".form-center input");

      inputList.forEach(function(input) {
        if (input.type === "radio") return;
        memberFormObj[input.name] = input.value;
      });

      //라디오버튼
      const radios = document.querySelectorAll('input[type="radio"]');
      radios.forEach(function(option) {
        if (option.checked) {
          memberFormObj[option.name] = option.value;
        }
      });

      console.log(JSON.stringify(memberFormObj));
      SignupBtn.prototype.sendMemberObj(memberFormObj);
    },

    sendMemberObj: function(memberFormObj) {
      let oReq = new XMLHttpRequest();

      oReq.open("POST", "./api/auth/signup");
      oReq.setRequestHeader("Content-Type", "application/json");
      oReq.addEventListener("load", function() {
        const responseData = JSON.parse(oReq.responseText);

        alert(responseData.message);

        if (oReq.status !== 200) {
          SignupBtn.prototype.setResponseMSg(responseData);
        }
      });

      oReq.send(JSON.stringify(memberFormObj));
    },

    setResponseMSg: function(responseData) {
      MemberInput.prototype.initAllMsg();
      const responseList = responseData.errors;

      responseList.forEach(function(response) {
        const input = document.getElementById(response.field);
        let msgSpan = "";

        if (response.field === "memberGender") {
          msgSpan = document.querySelector("#genderMsg");
        } else {
          msgSpan = input.nextElementSibling;
        }

        MsgToggle.prototype.showMsg(msgSpan, response.reason);
      });
    }
  };

  const MemberInput = function() {};

  MemberInput.prototype = {
    inputList: document.querySelectorAll("form input"),
    messageList: document.querySelectorAll(".error_message"),

    initAllMsg: function() {
      MemberInput.prototype.messageList.forEach(function(msgSpan) {
        MsgToggle.prototype.hideMsg(msgSpan);
      });
    },

    isAllInputFilled: function() {
      MemberInput.prototype.initAllMsg();

      const inputFilledArray = Array.from(MemberInput.prototype.inputList).map(
        function(input) {
          return MemberInput.prototype.isEachInputFilled(input);
        }
      );

      const isInputFilledArray = inputFilledArray.every(function(element) {
        return element == true;
      });

      return isInputFilledArray;
    },

    isEachInputFilled: function(memberInput) {
      //라디오 버튼일 때 (성별)
      if (memberInput.type === "radio") {
        return MemberInput.prototype.isGenderChecked();
      }

      //그 외
      if (memberInput.value === "") {
        const msgSpan = memberInput.nextElementSibling;
        MsgToggle.prototype.showMsg(msgSpan, "필수 정보입니다");
        return false;
      } else {
        return RegularExp.prototype.isInputValid(memberInput);
      }
    },

    isGenderChecked: function() {
      const radios = document.querySelectorAll('input[type="radio"]:checked');
      const genderMsgSpan = document.querySelector("#genderMsg");

      if (radios.length > 0) return true;

      MsgToggle.prototype.showMsg(genderMsgSpan, "필수 정보입니다");
      return false;
    }
  };

  const RegularExp = function() {};

  RegularExp.prototype = {
    isInputValid: function(memberInput) {
      const isInputMatched = RegularExp.prototype
        .getRegExp(memberInput.name)
        .test(memberInput.value);

      const msgSpan = memberInput.nextElementSibling;

      if (isInputMatched) {
        MsgToggle.prototype.hideMsg(msgSpan);
        return true;
      } else {
        MsgToggle.prototype.showMsg(
          msgSpan,
          RegularExp.prototype.getErrorMsg(memberInput.name)
        );

        return false;
      }
    },

    getRegExp: function(memberInputName) {
      switch (memberInputName) {
        case "memberId":
          return /^[a-z0-9_-]{5,20}$/;
        case "memberPw":
          return /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$/;
        case "memberName":
          return /^[가-힣]{2,4}/;
        case "memberPhone":
          return /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
        case "memberBirthday":
          return /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
      }
    },

    getErrorMsg: function(memberInputName) {
      switch (memberInputName) {
        case "memberId":
          return "아이디 형식을 확인해주세요";
        case "memberPw":
          return "비밀번호 형식을 확인해주세요";
        case "memberName":
          return "이름 형식을 확인해주세요";
        case "memberPhone":
          return "전화번호 형식을 확인해주세요";
        case "memberBirthday":
          return "생년월일 형식을 확인해주세요";
      }
    }
  };

  function initJS() {
    new SignupBtn();
  }

  initJS();
});
