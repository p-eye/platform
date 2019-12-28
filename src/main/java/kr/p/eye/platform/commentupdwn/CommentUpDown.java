package kr.p.eye.platform.commentupdwn;

public class CommentUpDown {

	private int id;
	private int commentId;
	private int memberNo;

	public CommentUpDown() {
	}

	public CommentUpDown(int id, int commentId, int memberNo) {
		this.id = id;
		this.commentId = commentId;
		this.memberNo = memberNo;
	}
	
	

	public CommentUpDown(int commentId, int memberNo) {
		this.commentId = commentId;
		this.memberNo = memberNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "CommentUpDown [id=" + id + ", commentId=" + commentId + ", memberNo=" + memberNo + "]";
	}

}
