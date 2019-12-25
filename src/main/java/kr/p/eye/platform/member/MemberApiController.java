package kr.p.eye.platform.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.p.eye.platform.common.response.Response;

@RestController
@RequestMapping(path = "/api/auth")
@CrossOrigin
public class MemberApiController {

	@Autowired
	MemberService memberService;

	@PostMapping(path = "/signup")
	public ResponseEntity<?> signupMember(@RequestBody @Valid MemberRequest memberRequest) {

		MemberResponse memberResponse = memberService.insertMemberRequest(memberRequest);
		return new ResponseEntity<>(new Response(memberResponse, "가입에 성공하였습니다."), HttpStatus.OK);

	}
}
