package kr.p.eye.platform.episode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	EpisodeDao episodeDao;

	@Override
	public EpisodeResponse getEpisodeResponse(int productId, int page) {

		EpisodeResponse episodeResponse = createEpisodeResponse(productId);
		episodeResponse.setEpisodes(getEpisodeList(productId, page));

		return episodeResponse;

	}

	public EpisodeResponse createEpisodeResponse(int productId) {
		return episodeDao.getEpisodeResponse(productId);
	}

	public List<Episode> getEpisodeList(int productId, int page) {
		int lastPage = (int) Math.ceil((double) countEpisodes(productId) / EPISODE_PER_PAGE);

		if (page < 1) {
			page = 1;
		}

		else if (page > lastPage) {
			page = lastPage;
		}

		page = (page - 1) * EPISODE_PER_PAGE;

		return episodeDao.getEpisodeList(productId, page, EPISODE_PER_PAGE);
	}

	public int countEpisodes(int productId) {
		return episodeDao.countEpisodes(productId);
	}
}
