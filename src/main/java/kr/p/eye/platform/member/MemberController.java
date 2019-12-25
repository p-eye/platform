package kr.p.eye.platform.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	@Autowired
	MemberDao memberDao;

	@GetMapping(path = "/signup")
	public String getSignup() {
		return "signup";

	}

	@GetMapping(path = "/signinForm")
	public String getSignin() {
		return "signin";
	}

	@PostMapping(path = "/signin")
	public void postSignin(MemberRequest memberRequest, Model model) {

		String memberId = memberRequest.getMemberId();
		String memberPw = memberRequest.getMemberPw();

		if (memberDao.getMember(memberId) == null) {
			model.addAttribute("errorMsg", "등록된 이메일이 없습니다");
			return;
		}

		if (!memberDao.getMember(memberId).getMemberPw().equals(memberPw)) {
			model.addAttribute("errorMsg", "비밀번호가 일치하지 않습니다");
			return;
		}

		model.addAttribute("memberId", memberId);

	}
}
