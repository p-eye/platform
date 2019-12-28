package kr.p.eye.platform.comment;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {

	public static final Integer COMMENT_PER_PAGE = 5;
	public static final Integer PAGE_RANGE = 6;

	public List<Comment> getCommentListByDate(int episodeId, int page);

	public List<Comment> getCommentListByDateLogin(int memberNo, int episodeId, int page);

	public CommentResponse upComment(int commentId, int memberNo);

	public CommentResponse downComment(int commentId, int memberNo);

	public CommentResponse insertComment(CommentRequest commentRequest);

	public int countCommentList(int episodeId);

}
