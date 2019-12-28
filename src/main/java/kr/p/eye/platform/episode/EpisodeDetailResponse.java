package kr.p.eye.platform.episode;

import java.util.List;

import kr.p.eye.platform.comment.Comment;

public class EpisodeDetailResponse {

	private int productId;
	private int episodeId;
	private int episodeNo;
	private String title;
	private String content;
	private String writer;
	private String episodeName;
	private double starScore;
	private String createDate;
	private int commentCount;
	private List<Comment> commentList;

	public EpisodeDetailResponse() {
	}

	public EpisodeDetailResponse(int productId, int episodeId, int episodeNo, String title, String content,
			String writer, String episodeName, double starScore, String createDate, int commentCount,
			List<Comment> commentList) {
		this.productId = productId;
		this.episodeId = episodeId;
		this.episodeNo = episodeNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.episodeName = episodeName;
		this.starScore = starScore;
		this.createDate = createDate;
		this.commentCount = commentCount;
		this.commentList = commentList;
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

	public int getEpisodeNo() {
		return episodeNo;
	}

	public void setEpisodeNo(int episodeNo) {
		this.episodeNo = episodeNo;
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

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "EpisodeDetailResponse [productId=" + productId + ", episodeId=" + episodeId + ", episodeNo=" + episodeNo
				+ ", title=" + title + ", content=" + content + ", writer=" + writer + ", episodeName=" + episodeName
				+ ", starScore=" + starScore + ", createDate=" + createDate + ", commentCount=" + commentCount
				+ ", commentList=" + commentList + "]";
	}

}
