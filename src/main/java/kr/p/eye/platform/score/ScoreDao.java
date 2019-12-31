package kr.p.eye.platform.score;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	public ScoreDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("score")
				.usingGeneratedKeyColumns("id");
	}


	public int insertScore(ScoreRequest scoreRequest) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(scoreRequest);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public int getStarCount(int episodeId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("episodeId", episodeId);
		String sql = 
				"SELECT star_count "
				+"FROM episode_info "
				+"WHERE id = :episodeId";
		
		return jdbc.queryForObject(sql, params, Integer.class);
	}
	
	public double getAvgStarScore(int episodeId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("episodeId", episodeId);
		String sql = 
				"SELECT AVG(s.score) "
				+"FROM score s "
				+"WHERE s.episode_id = :episodeId";
		return jdbc.queryForObject(sql, params, Double.class);
	}
	
	public int updateScoreCount(int episodeId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("episodeId", episodeId);
		String sql = "UPDATE episode_info SET star_count = star_count + 1 WHERE id = :episodeId";
		return jdbc.update(sql, params);
	}
}
