package kr.p.eye.platform.episode;

public class Episode {
	private int productId;
	private int episodeId;
	private String episodeName;
	private double starScore;
	private String createDate;

	public Episode() {
	}

	public Episode(int productId, int episodeId, String episodeName, double starScore, String createDate) {
		this.productId = productId;
		this.episodeId = episodeId;
		this.episodeName = episodeName;
		this.starScore = starScore;
		this.createDate = createDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(int episodeId) {
		this.episodeId = episodeId;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public double getStarScore() {
		return starScore;
	}

	public void setStarScore(double starScore) {
		this.starScore = starScore;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Episode [productId=" + productId + ", episodeId=" + episodeId + ", episodeName=" + episodeName
				+ ", starScore=" + starScore + ", createDate=" + createDate + "]";
	}

}
