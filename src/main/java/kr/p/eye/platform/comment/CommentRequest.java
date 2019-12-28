package kr.p.eye.platform.comment;

import java.time.LocalDateTime;

public class CommentRequest {

	private int id;
	private int episodeId;
	private String commentWriter;
	private String commentContent;
	private int upCount;
	private int downCount;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;

	public CommentRequest() {
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
	}

	public CommentRequest(int id, int episodeId, String commentWriter, String commentContent, int upCount,
			int downCount, LocalDateTime createDate, LocalDateTime modifyDate) {
		this.id = id;
		this.episodeId = episodeId;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
		this.upCount = upCount;
		this.downCount = downCount;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(int episodeId) {
		this.episodeId = episodeId;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getUpCount() {
		return upCount;
	}

	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
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
		return "CommentRequest [id=" + id + ", episodeId=" + episodeId + ", commentWriter=" + commentWriter
				+ ", commentContent=" + commentContent + ", upCount=" + upCount + ", downCount=" + downCount
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

}
