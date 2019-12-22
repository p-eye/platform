package kr.p.eye.platform.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
@CrossOrigin
public class MemberApiController {

	@Autowired
	MemberService memberService;

	@PostMapping(path = "/signup/id")
	public ResponseEntity<?> signupMemberId(@RequestBody MemberRequest memberRequest) {

		String memberId = memberRequest.getMemberId();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=UTF-8");

		memberService.isIdPassed(memberId);
		System.out.println("1111");

		/*
		 * //이미 등록된 이메일 if (!memberService.isIdNew(memberId)) { return new
		 * ResponseEntity<>(HttpStatus.BAD_REQUEST); }
		 * 
		 * //사용 가능한 이메일
		 * 
		 * return new ResponseEntity<>(HttpStatus.OK);
		 * 
		 */
		return new ResponseEntity<>(responseHeaders, HttpStatus.OK);

	}

	@PostMapping(path = "/signup")
	public void signupMember(@RequestBody MemberRequest memberRequest) {

		memberService.insertMember(memberRequest);

	}
}
