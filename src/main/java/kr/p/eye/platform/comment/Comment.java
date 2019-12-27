package kr.p.eye.platform.comment;

public class Comment {

	private int commentId;
	private int episodeId;
	private int score;
	private String commentWriter;
	private String comment;
	private int commentLike;
	private int commentDislike;
	private String createDate;

	public Comment() {
	}

	public Comment(int commentId, int episodeId, int score, String commentWriter, String comment, int commentLike,
			int commentDislike, String createDate) {
		this.commentId = commentId;
		this.episodeId = episodeId;
		this.score = score;
		this.commentWriter = commentWriter;
		this.comment = comment;
		this.commentLike = commentLike;
		this.commentDislike = commentDislike;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public int getCommentLike() {
		return commentLike;
	}

	public void setCommentLike(int commentLike) {
		this.commentLike = commentLike;
	}

	public int getCommentDislike() {
		return commentDislike;
	}

	public void setCommentDislike(int commentDislike) {
		this.commentDislike = commentDislike;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", episodeId=" + episodeId + ", score=" + score + ", commentWriter="
				+ commentWriter + ", comment=" + comment + ", commentLike=" + commentLike + ", commentDislike="
				+ commentDislike + ", createDate=" + createDate + "]";
	}

}
