package kr.p.eye.platform.comment;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {

	public static final Integer COMMENT_PER_PAGE = 5;
	public static final Integer PAGE_RANGE = 6;
	
	public List<Comment> getCommentListByDate(int episodeId, int page);

	public int thumbsupComment(int commentId);
	
	public int thumbsdownComment(int commentId);

}
