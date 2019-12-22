package kr.p.eye.platform.member;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
		

	public Member getMember() {
	
			String sql = "SELECT * FROM member_info";
			return jdbc.queryForObject(sql,  Collections.emptyMap(), rowMapper);


	}

}
