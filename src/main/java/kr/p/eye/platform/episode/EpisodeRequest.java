package kr.p.eye.platform.episode;

import java.time.LocalDateTime;

public class EpisodeRequest {

	private int id;
	private int productId;
	private String episodeName;
	private String writer;
	private int viewCnt;
	private int starScore;
	private int starScoreCount;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;

	public EpisodeRequest() {
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
	}

	public EpisodeRequest(int id, int productId, String episodeName, String writer, int viewCnt, int starScore,
			int starScoreCount, LocalDateTime createDate, LocalDateTime modifyDate) {
		this.id = id;
		this.productId = productId;
		this.episodeName = episodeName;
		this.writer = writer;
		this.viewCnt = viewCnt;
		this.starScore = starScore;
		this.starScoreCount = starScoreCount;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getStarScore() {
		return starScore;
	}

	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}

	public int getStarScoreCount() {
		return starScoreCount;
	}

	public void setStarScoreCount(int starScoreCount) {
		this.starScoreCount = starScoreCount;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "EpisodeRequest [id=" + id + ", productId=" + productId + ", episodeName=" + episodeName + ", writer="
				+ writer + ", viewCnt=" + viewCnt + ", starScore=" + starScore + ", starScoreCount=" + starScoreCount
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

}
