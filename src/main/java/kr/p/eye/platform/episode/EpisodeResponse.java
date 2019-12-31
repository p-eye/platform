package kr.p.eye.platform.episode;

import java.util.List;

public class EpisodeResponse {

	private int totalCount;
	private String title;
	private String content;
	private String writer;
	private double starScore;
	private int starCount;
	private String productImageUrl;
	private List<Episode> episodes;

	public EpisodeResponse() {
	}

	public EpisodeResponse(int totalCount, String title, String content, String writer, double starScore, int starCount,
			String productImageUrl, List<Episode> episodes) {
		this.totalCount = totalCount;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.starScore = starScore;
		this.starCount = starCount;
		this.productImageUrl = productImageUrl;
		this.episodes = episodes;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public double getStarScore() {
		return starScore;
	}

	public void setStarScore(double starScore) {
		this.starScore = starScore;
	}

	public int getStarCount() {
		return starCount;
	}

	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	@Override
	public String toString() {
		return "EpisodeResponse [totalCount=" + totalCount + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", starScore=" + starScore + ", starCount=" + starCount + ", productImageUrl="
				+ productImageUrl + ", episodes=" + episodes + "]";
	}

}
