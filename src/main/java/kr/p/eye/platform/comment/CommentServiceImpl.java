package kr.p.eye.platform.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;

	@Override
	public List<Comment> getCommentListByDate(int episodeId, int page) {
		return commentDao.getCommentListByDate(episodeId, page, COMMENT_PER_PAGE);
	}

	
	@Override
	public int thumbsupComment(int commentId) {
		return commentDao.thumbsupComment(commentId);
	}


	@Override
	public int thumbsdownComment(int commentId) {
		return commentDao.thumbsdownComment(commentId);


	}
	
	
}
