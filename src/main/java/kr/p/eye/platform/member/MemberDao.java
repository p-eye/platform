package kr.p.eye.platform.member;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
	private SimpleJdbcInsert insertAction;

	public MemberDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("member_info")
				.usingGeneratedKeyColumns("member_no");
	}
		

	public int insertMember(MemberRequest memberRequest) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(memberRequest);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	
	public Member getMember(String memberId) {
		try {
			Map<String, String> params = new HashMap<>();
			params.put("memberId", memberId);
			String sql = "SELECT * FROM member_info WHERE member_id = :memberId";
			return jdbc.queryForObject(sql, params, rowMapper);

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
