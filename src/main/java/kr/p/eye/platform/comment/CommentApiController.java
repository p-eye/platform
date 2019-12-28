package kr.p.eye.platform.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.p.eye.platform.common.response.Response;
import kr.p.eye.platform.member.MemberDao;
import kr.p.eye.platform.member.MemberRequest;

@RestController
@RequestMapping(path = "/api/comments")
@CrossOrigin
public class CommentApiController {

	private static final String LOGIN = "login";

	@Autowired
	CommentService commentService;

	@Autowired
	MemberDao memberDao;

	@PostMapping(path = "/{commentId}/up")
	public ResponseEntity<?> thumbsupComment(@PathVariable int commentId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberRequest memberRequest = (MemberRequest) session.getAttribute(LOGIN);

		int loggedMemberNo = memberDao.getMember(memberRequest.getMemberId()).getMemberNo();
		CommentResponse commentResponse = commentService.upComment(commentId, loggedMemberNo);
		return new ResponseEntity<>(new Response(commentResponse, "요청을 성공적으로 처리하였습니다"), HttpStatus.OK);
	}

	@PostMapping(path = "/{commentId}/down")
	public ResponseEntity<?> thumbsdownComment(@PathVariable int commentId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberRequest memberRequest = (MemberRequest) session.getAttribute(LOGIN);

		int loggedMemberNo = memberDao.getMember(memberRequest.getMemberId()).getMemberNo();
		CommentResponse commentResponse = commentService.downComment(commentId, loggedMemberNo);
		return new ResponseEntity<>(new Response(commentResponse, "요청을 성공적으로 처리하였습니다"), HttpStatus.OK);
	}
}
