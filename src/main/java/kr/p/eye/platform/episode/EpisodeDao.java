package kr.p.eye.platform.episode;

import static kr.p.eye.platform.episode.EpisodeDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EpisodeDao {

	private NamedParameterJdbcTemplate jdbc;

	public EpisodeDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Episode> getEpisodeList(int productId, int page, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("page", page);
		params.put("limit", limit);

		return jdbc.query(GET_EPISODE_LIST, params, BeanPropertyRowMapper.newInstance(Episode.class));
	}

	public EpisodeResponse getEpisodeResponse(int productId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("productId", productId);

			return jdbc.queryForObject(GET_EPISODE_RESPONSE, params,
					BeanPropertyRowMapper.newInstance(EpisodeResponse.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public int countEpisodes(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);

		return jdbc.queryForObject(COUNT_EPISODES, params, Integer.class);
	}

	public EpisodeDetailResponse getEpisodeDetailResponse(int productId, int episodeNo) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("episodeNo", episodeNo);

		return jdbc.queryForObject(GET_EPISODE_DETAIL_RESPONSE, params,
				BeanPropertyRowMapper.newInstance(EpisodeDetailResponse.class));

	}

	public int getEpisodeId(int productId, int episodeNo) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("episodeNo", episodeNo);

		return jdbc.queryForObject(GET_EPISODE_ID, params, Integer.class);

	}

	public int updateViewCount(int episodeId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("episodeId", episodeId);

		return jdbc.update(UPDATE_VIEWCNT, params);
	}
}
