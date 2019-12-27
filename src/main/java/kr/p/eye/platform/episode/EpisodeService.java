package kr.p.eye.platform.episode;

import org.springframework.stereotype.Service;

@Service
public interface EpisodeService {

	public static final Integer EPISODE_PER_PAGE = 5;
	public static final Integer PAGE_RANGE = 6;
	
	public EpisodeResponse getEpisodeResponse(int productId, int page);

	public EpisodeDetailResponse getEpisodeDetailResponse(int productId, int episodeNo, int commentPage);

}
