package kr.p.eye.platform.comment;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

//		int loggedMemberNo = memberDao.getMember(memberRequest.getMemberId()).getMemberNo();
		CommentResponse commentResponse = commentService.upComment(commentId, 13);

		HashMap<String, Object> result = new HashMap<>();
		result.put("comment", commentResponse);
		return new ResponseEntity<>(new Response(result, "요청을 성공적으로 처리하였습니다"), HttpStatus.OK);
	}

	@PostMapping(path = "/{commentId}/down")
	public ResponseEntity<?> thumbsdownComment(@PathVariable int commentId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberRequest memberRequest = (MemberRequest) session.getAttribute(LOGIN);

//		int loggedMemberNo = memberDao.getMember(memberRequest.getMemberId()).getMemberNo();
		CommentResponse commentResponse = commentService.downComment(commentId, 13);

		HashMap<String, Object> result = new HashMap<>();
		result.put("comment", commentResponse);
		return new ResponseEntity<>(new Response(result, "요청을 성공적으로 처리하였습니다"), HttpStatus.OK);
	}

	@PostMapping(path = "/{episodeId}")
	public ResponseEntity<?> postComment(CommentRequest commentRequest, HttpServletRequest request) {

		HttpSession session = request.getSession();
		MemberRequest memberRequest = (MemberRequest) session.getAttribute(LOGIN);

	//	int loggedMemberNo = memberDao.getMember(memberRequest.getMemberId()).getMemberNo();
		commentRequest.setMemberNo(13);

		HashMap<String, Object> result = new HashMap<>();
		result.put("comment", commentService.insertComment(commentRequest));
		result.put("commentList", commentService.getCommentListByDateLogin(commentRequest.getMemberNo(), commentRequest.getEpisodeId(), 0));
		result.put("commentCount", commentService.countCommentList(commentRequest.getEpisodeId()));
		
		return new ResponseEntity<>(new Response(result, "요청을 성공적으로 처리하였습니다"), HttpStatus.OK);
	}
	
	@GetMapping(path ="/{episodeId}/{page}")
	public ResponseEntity<?> getCommentList(@PathVariable int episodeId, @PathVariable int page, HttpServletRequest request) {
		

		HttpSession session = request.getSession();
		MemberRequest memberRequest = (MemberRequest) session.getAttribute(LOGIN);

	//	int loggedMemberNo = memberDao.getMember(memberRequest.getMemberId()).getMemberNo();
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("commentList", commentService.getCommentListByDateLogin(13, episodeId, page));
		return new ResponseEntity<>(new Response(result, "요청을 성공적으로 처리하였습니다"), HttpStatus.OK);
	}

}
