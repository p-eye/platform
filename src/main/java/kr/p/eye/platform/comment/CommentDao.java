package kr.p.eye.platform.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {

	private NamedParameterJdbcTemplate jdbc;

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Comment> getCommentListByBest(int episodeId, int page, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("episodeId", episodeId);
		params.put("page", page);
		params.put("limit", limit);

		String sql = "SELECT c.id AS comment_id, " + "c.episode_id, " + "c.comment_writer, "
				+ "c.comment_content AS comment, " + "c.up_count, " + "c.down_count, " + "c.create_date "
				+ "FROM episode_comment c " + "WHERE c.episode_id = :episodeId " + "ORDER BY c.comment_like DESC "
				+ "limit :page, :limit";

		return jdbc.query(sql, params, BeanPropertyRowMapper.newInstance(Comment.class));
	}

	public List<Comment> getCommentListByDate(int episodeId, int page, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("episodeId", episodeId);
		params.put("page", page);
		params.put("limit", limit);

		String sql = "SELECT c.id AS comment_id, " + "c.episode_id, " + "c.comment_writer, "
				+ "c.comment_content AS comment, " + "c.up_count, " + "c.down_count, " + "c.create_date "
				+ "FROM episode_comment c " + "WHERE c.episode_id = :episodeId " + "ORDER BY c.create_date DESC "
				+ "limit :page, :limit";

		return jdbc.query(sql, params, BeanPropertyRowMapper.newInstance(Comment.class));
	}

	public int plusCommentUp(int commentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		String sql = "UPDATE episode_comment c " + "SET up_count = up_count + 1 " + "WHERE id = :commentId";
		return jdbc.update(sql, params);
	}

	public int minusCommentUp(int commentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		String sql = "UPDATE episode_comment c " + "SET up_count = up_count - 1 " + "WHERE id = :commentId";
		return jdbc.update(sql, params);
	}

	public int plusCommentDown(int commentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		String sql = "UPDATE episode_comment c " + "SET down_count = down_count + 1 " + "WHERE id = :commentId";
		return jdbc.update(sql, params);
	}

	public int minusCommentDown(int commentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		String sql = "UPDATE episode_comment c " + "SET down_count = down_count - 1 " + "WHERE id = :commentId";
		return jdbc.update(sql, params);
	}

	public int isMemberThumbsUp(int commentId, int memberNo) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("commentId", commentId);
			params.put("memberNo", memberNo);
			String sql = "SELECT id " + "FROM comment_up " + "WHERE comment_id =:commentId "
					+ "AND member_no = :memberNo";
			return jdbc.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}

	}

	public int isMemberThumbsDown(int commentId, int memberNo) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("commentId", commentId);
			params.put("memberNo", memberNo);
			String sql = "SELECT id " + "FROM comment_down " + "WHERE comment_id =:commentId "
					+ "AND member_no = :memberNo";
			return jdbc.queryForObject(sql, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}

	}

	public CommentResponse getCommentResponse(int commentId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("commentId", commentId);
			String sql = "SELECT c.id AS comment_id, " + "c.episode_id, " + "c.comment_writer, "
					+ "c.comment_content AS comment, " + "c.up_count, " + "c.down_count, " + "c.create_date "
					+"FROM episode_comment c "
					+ "WHERE id = :commentId";
			return jdbc.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(CommentResponse.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
