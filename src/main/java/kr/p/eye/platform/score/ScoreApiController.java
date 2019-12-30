package kr.p.eye.platform.score;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.p.eye.platform.common.response.Response;
import kr.p.eye.platform.member.MemberRequest;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class ScoreApiController {

	private static final String LOGIN = "login";

	@Autowired
	ScoreService scoreService;


	@PostMapping(path = "/score")
	public ResponseEntity<?> insertScore(@RequestBody ScoreRequest scoreRequest, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberRequest memberRequest = (MemberRequest) session.getAttribute(LOGIN);

//		int loggedMemberNo = memberDao.getMember(memberRequest.getMemberId()).getMemberNo();
		
		System.out.println(scoreRequest);
		scoreRequest.setMemberNo(17);
		ScoreResponse scoreResponse = scoreService.insertScore(scoreRequest);
		HashMap<String, Object> result = new HashMap<>();
		result.put("score", scoreResponse);
		return new ResponseEntity<>(new Response(result, "별점이 등록되었습니다"), HttpStatus.OK);
	}
}
