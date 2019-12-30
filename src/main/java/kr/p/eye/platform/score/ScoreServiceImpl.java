package kr.p.eye.platform.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.p.eye.platform.episode.EpisodeDao;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	ScoreDao scoreDao;
	
	@Autowired
	EpisodeDao episodeDao;
	

	@Override
	public ScoreResponse insertScore(ScoreRequest scoreRequest) {
		int episodeId = episodeDao.getEpisodeId(scoreRequest.getProductId(), scoreRequest.getEpisodeNo());
		
		scoreRequest.setEpisodeId(episodeId);
		scoreDao.insertScore(scoreRequest);
	
		ScoreResponse scoreResponse = new ScoreResponse();
		scoreResponse.setStarCount(getStarCount(episodeId));
		scoreResponse.setAvgStarScore(getAvgStarScore(episodeId));

		return scoreResponse;

	}

	@Override
	public int getStarCount(int episodeId) {
		return scoreDao.getStarCount(episodeId);
	}

	@Override
	public double getAvgStarScore(int episodeId) {
		return scoreDao.getAvgStarScore(episodeId);
	}

}
