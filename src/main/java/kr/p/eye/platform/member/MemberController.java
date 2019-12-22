package kr.p.eye.platform.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping(path = "/signup")
	public String getDetail() {
		return "signup";

	}
}
