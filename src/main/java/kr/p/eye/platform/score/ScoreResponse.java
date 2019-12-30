package kr.p.eye.platform.score;

public class ScoreResponse {

	private int starCount;
	private double avgStarScore;

	public ScoreResponse() {
	}

	public ScoreResponse(int starCount, double avgStarScore) {
		this.starCount = starCount;
		this.avgStarScore = avgStarScore;
	}

	public int getStarCount() {
		return starCount;
	}

	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}

	public double getAvgStarScore() {
		return avgStarScore;
	}

	public void setAvgStarScore(double avgStarScore) {
		this.avgStarScore = avgStarScore;
	}

	@Override
	public String toString() {
		return "ScoreResponse [starCount=" + starCount + ", avgStarScore=" + avgStarScore + "]";
	}

}
