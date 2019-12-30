package kr.p.eye.platform.episode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.p.eye.platform.member.MemberRequest;
import kr.p.eye.platform.member.MemberService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class EpisodeApiController {

	private static final String LOGIN = "login";

	@Autowired
	EpisodeService episodeService;

	@Autowired
	MemberService memberService;

	@GetMapping(path = "/list/{productId}/{page}")
	public EpisodeResponse getEpisodeResponse(@PathVariable(name = "productId", required = true) int productId,
			@PathVariable(name = "page", required = true) int page) {
		return episodeService.getEpisodeResponse(productId, page);
	}

	@GetMapping(path = "/detail/{productId}/{no}/{commentPage}")
	public EpisodeDetailResponse getEpisodeDetailResponse(
			@PathVariable(name = "productId", required = true) int productId,
			@PathVariable(name = "no", required = true) int no,
			@PathVariable(name = "commentPage", required = true) int commentPage, HttpServletRequest request) {

		HttpSession session = request.getSession();
		MemberRequest memberRequest = (MemberRequest) session.getAttribute(LOGIN);

		if (memberRequest == null) {
			return episodeService.getEpisodeDetailResponse(productId, no, commentPage);
		} else {
			int loggedMemberNo = memberService.getMember(memberRequest.getMemberId()).getMemberNo();
			return episodeService.getEpisodeDetailResponseLogin(loggedMemberNo, productId, no, commentPage);
		}

	}

}
