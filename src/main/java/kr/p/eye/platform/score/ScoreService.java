package kr.p.eye.platform.score;

import org.springframework.stereotype.Service;

@Service
public interface ScoreService {

	public ScoreResponse insertScore(ScoreRequest scoreRequest);
	
	public int getStarCount(int episodeId);
	
	public double getAvgStarScore(int episodeId);

}
