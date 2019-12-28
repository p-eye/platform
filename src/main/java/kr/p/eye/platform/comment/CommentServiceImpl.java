package kr.p.eye.platform.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.p.eye.platform.commentupdwn.CommentDownDao;
import kr.p.eye.platform.commentupdwn.CommentUpDao;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;

	@Autowired
	CommentUpDao commentUpDao;

	@Autowired
	CommentDownDao commentDownDao;

	@Override
	public List<Comment> getCommentListByDate(int episodeId, int page) {
		return commentDao.getCommentListByDate(episodeId, page, COMMENT_PER_PAGE);
	}

	@Override
	public List<Comment> getCommentListByDateLogin(int memberNo, int episodeId, int page) {
		List<Comment> commentList = commentDao.getCommentListByDate(episodeId, page, COMMENT_PER_PAGE);
		for (Comment comment : commentList) {
			int commentId = comment.getCommentId();
			comment.setUp(isMemberThumbsUp(commentId, memberNo));
			comment.setDown(isMemberThumbsDown(commentId, memberNo));
		}

		return commentList;
	}

	@Override
	public CommentResponse upComment(int commentId, int memberNo) {
		thumbsUpComment(commentId, memberNo);
		return getCommentResponse(commentId);
	}

	@Override
	public CommentResponse downComment(int commentId, int memberNo) {
		thumbsDownComment(commentId, memberNo);
		return getCommentResponse(commentId);
	}

	public int thumbsUpComment(int commentId, int memberNo) {
		if (!isMemberThumbsUp(commentId, memberNo)) {
			commentDao.plusCommentUp(commentId);
			return commentUpDao.insertCommentUp(commentId, memberNo);

		} else {
			commentDao.minusCommentUp(commentId);
			return commentUpDao.deleteCommentUp(commentId, memberNo);
		}
	}

	public int thumbsDownComment(int commentId, int memberNo) {
		if (!isMemberThumbsDown(commentId, memberNo)) {
			commentDao.plusCommentDown(commentId);
			return commentDownDao.insertCommentDown(commentId, memberNo);

		} else {
			commentDao.minusCommentDown(commentId);
			return commentDownDao.deleteCommentDown(commentId, memberNo);
		}

	}

	public boolean isMemberThumbsUp(int commentId, int memberNo) {
		if (commentDao.isMemberThumbsUp(commentId, memberNo) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isMemberThumbsDown(int commentId, int memberNo) {
		if (commentDao.isMemberThumbsDown(commentId, memberNo) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public CommentResponse getCommentResponse(int commentId) {
		return commentDao.getCommentResponse(commentId);
	}

}
