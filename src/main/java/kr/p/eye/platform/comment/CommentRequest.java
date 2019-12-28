package kr.p.eye.platform.comment;

import java.time.LocalDateTime;

public class CommentRequest {

	private int id;
	private int episodeId;
	private int memberNo;
	private String commentContent;
	private int upCount;
	private int downCount;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;

	public CommentRequest() {
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
	}

	public CommentRequest(int id, int episodeId, int memberNo, String commentContent, int upCount, int downCount,
			LocalDateTime createDate, LocalDateTime modifyDate) {
		this.id = id;
		this.episodeId = episodeId;
		this.memberNo = memberNo;
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

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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
		return "CommentRequest [id=" + id + ", episodeId=" + episodeId + ", memberNo=" + memberNo + ", commentContent="
				+ commentContent + ", upCount=" + upCount + ", downCount=" + downCount + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}

}
