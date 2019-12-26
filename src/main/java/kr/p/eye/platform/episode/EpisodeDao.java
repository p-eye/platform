package kr.p.eye.platform.episode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EpisodeDao {

	private NamedParameterJdbcTemplate jdbc;

	public EpisodeDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Episode> getEpisodeList(int productId, int page, int limit){ 
	Map<String, Integer> params = new HashMap<>();
	params.put("productId", productId);
	params.put("page", page);
	params.put("limit", limit);
	
		String sql = 
				"SELECT e.product_id, "
				+"e.id AS episode_id, "
				+"@rownum := @rownum +1 AS episode_no, "
				+"e.episode_name, "
				+"e.star_score, "
				+"e.create_date "
				+"FROM episode_info e "
				+"INNER JOIN product p "
				+"ON p.id = e.product_id, "
				+"(SELECT @rownum := 0) r "
				+"WHERE e.product_id = :productId "
				+"ORDER BY episode_no DESC "
				+"limit :page, :limit";
		
		return jdbc.query(sql, params, BeanPropertyRowMapper.newInstance(Episode.class));
	}
	
	
	public EpisodeResponse getEpisodeResponse(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		
		String sql = 
				"SELECT count(e.id) AS total_count, "
				+"p.title, "
				+"p.content, "
				+"p.writer "
				+"FROM episode_info e "
				+"INNER JOIN product p "
				+"ON p.id = e.product_id "
				+"WHERE e.product_id = :productId "
				+"GROUP BY e.product_id";
		
		return jdbc.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(EpisodeResponse.class));
	}
	
	public int countEpisodes(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		String sql = 
				"SELECT count(e.id) "
				+"FROM episode_info e "
				+"WHERE e.product_id = :productId";
		return jdbc.queryForObject(sql, params, Integer.class);
	}
}
