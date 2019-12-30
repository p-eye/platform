package kr.p.eye.platform.fileinfo;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class FileinfoDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Fileinfo> rowMapper = BeanPropertyRowMapper.newInstance(Fileinfo.class);
	private SimpleJdbcInsert insertAction;

	public FileinfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("file_info").usingGeneratedKeyColumns("id");
	}

	public int insertFileinfo(Fileinfo fileinfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(fileinfo);
		return insertAction.executeAndReturnKey(params).intValue();
	}

}
