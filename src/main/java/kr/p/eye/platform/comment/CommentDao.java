package kr.p.eye.platform.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {

	private NamedParameterJdbcTemplate jdbc;

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Comment> getCommentListByBest(int episodeId, int page, int limit){ 
	Map<String, Integer> params = new HashMap<>();
	params.put("episodeId", episodeId);
	params.put("page", page);
	params.put("limit", limit);
	
		String sql = 
				"SELECT c.id AS comment_id, "
				+"c.episode_id, "
				+"c.score, "
				+"c.comment_writer, "
				+"c.comment_content AS comment, "
				+"c.comment_like, "
				+"c.comment_dislike, "
				+"c.create_date "
				+"FROM episode_comment c "
				+"WHERE c.episode_id = :episodeId "
				+"ORDER BY c.comment_like DESC "
				+"limit :page, :limit";
		
		return jdbc.query(sql, params, BeanPropertyRowMapper.newInstance(Comment.class));
	}
	
	
	public List<Comment> getCommentListByDate(int episodeId, int page, int limit){ 
	Map<String, Integer> params = new HashMap<>();
	params.put("episodeId", episodeId);
	params.put("page", page);
	params.put("limit", limit);
	
		String sql = 
				"SELECT c.id AS comment_id, "
				+"c.episode_id, "
				+"c.score, "
				+"c.comment_writer, "
				+"c.comment_content AS comment, "
				+"c.comment_like, "
				+"c.comment_dislike, "
				+"c.create_date "
				+"FROM episode_comment c "
				+"WHERE c.episode_id = :episodeId "
				+"ORDER BY c.create_date DESC "
				+"limit :page, :limit";
		
		return jdbc.query(sql, params, BeanPropertyRowMapper.newInstance(Comment.class));
	}

	public int thumbsupComment(int commentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		String sql = 
				"UPDATE episode_comment c "
				+"SET comment_like = comment_like + 1 "
				+"WHERE id = :commentId";
		return jdbc.update(sql, params);
	}
	
	public int thumbsdownComment(int commentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		String sql = 
				"UPDATE episode_comment c "
				+"SET comment_dislike = comment_dislike + 1 "
				+"WHERE id = :commentId";
		return jdbc.update(sql, params);
	}

}
