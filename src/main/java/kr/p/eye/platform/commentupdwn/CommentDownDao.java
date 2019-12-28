package kr.p.eye.platform.commentupdwn;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDownDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	public CommentDownDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("comment_down").usingGeneratedKeyColumns("id");
	}

	public int insertCommentDown(int commentId, int memberNo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(new CommentUpDown(commentId, memberNo));
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public int deleteCommentDown(int commentId, int memberNo) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		params.put("memberNo", memberNo);
		String DELETE_COMMENT_UP = "DELETE FROM comment_down WHERE comment_id = :commentId AND member_no = :memberNo";
		return jdbc.update(DELETE_COMMENT_UP, params);
	}

}
