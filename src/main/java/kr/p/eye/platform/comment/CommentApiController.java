package kr.p.eye.platform.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/comments")
@CrossOrigin
public class CommentApiController {

	@Autowired
	CommentService commentService;

	@PostMapping(path="/{commentId}/up")
	public void thumbsupComment(@PathVariable int commentId) {
		commentService.thumbsupComment(commentId);
	}
	
	@PostMapping(path="/{commentId}/down")
	public void thumbsdownComment(@PathVariable int commentId) {
		commentService.thumbsdownComment(commentId);
	}
}
