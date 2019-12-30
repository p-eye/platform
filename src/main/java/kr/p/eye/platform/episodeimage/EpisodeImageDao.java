package kr.p.eye.platform.episodeimage;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class EpisodeImageDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	public EpisodeImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("episode_info_image")
				.usingGeneratedKeyColumns("id");
	}

	public int insertEpisodeImage(EpisodeImage episodeImage) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(episodeImage);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
