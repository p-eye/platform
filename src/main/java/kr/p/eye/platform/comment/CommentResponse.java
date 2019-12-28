package kr.p.eye.platform.comment;

public class CommentResponse {

	private int commentId;
	private String commentWriter;
	private String comment;
	private int upCount;
	private int downCount;
	private boolean up;
	private boolean down;
	private String createDate;

	public CommentResponse() {
	}

	public CommentResponse(int commentId, String commentWriter, String comment, int upCount, int downCount, boolean up,
			boolean down, String createDate) {
		this.commentId = commentId;
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
		return "CommentResponse [commentId=" + commentId + ", commentWriter=" + commentWriter + ", comment=" + comment
				+ ", upCount=" + upCount + ", downCount=" + downCount + ", up=" + up + ", down=" + down
				+ ", createDate=" + createDate + "]";
	}

}
