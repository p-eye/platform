package kr.p.eye.platform.score;

public class ScoreResponse {

	private int starCount;
	private double starScore;

	public ScoreResponse() {
	}

	public ScoreResponse(int starCount, double starScore) {
		this.starCount = starCount;
		this.starScore = starScore;
	}

	public int getStarCount() {
		return starCount;
	}

	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}

	public double getStarScore() {
		return starScore;
	}

	public void setStarScore(double starScore) {
		this.starScore = starScore;
	}

	@Override
	public String toString() {
		return "ScoreResponse [starCount=" + starCount + ", starScore=" + starScore + "]";
	}

}
