package kr.p.eye.platform.comment;

public class Comment {

	private int commentId;
	private int episodeId;
	private String commentWriter;
	private String comment;
	private int upCount;
	private int downCount;
	private boolean up;
	private boolean down;
	private String createDate;

	public Comment() {
	}

	public Comment(int commentId, int episodeId, String commentWriter, String comment, int upCount, int downCount,
			boolean up, boolean down, String createDate) {
		this.commentId = commentId;
		this.episodeId = episodeId;
		this.commentWriter = commentWriter;
		this.comment = comment;
		this.upCount = upCount;
		this.downCount = downCount;
		this.up = up;
		this.down = down;
		this.createDate = createDate;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", episodeId=" + episodeId + ", commentWriter=" + commentWriter
				+ ", comment=" + comment + ", upCount=" + upCount + ", downCount=" + downCount + ", up=" + up
				+ ", down=" + down + ", createDate=" + createDate + "]";
	}

}
