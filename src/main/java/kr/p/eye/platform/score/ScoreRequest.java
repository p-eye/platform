package kr.p.eye.platform.score;

public class ScoreRequest {

	private int id;
	private int productId;
	private int episodeNo;
	private int episodeId;
	private int memberNo;
	private int score;

	public ScoreRequest() {
	}

	public ScoreRequest(int id, int productId, int episodeNo, int episodeId, int memberNo, int score) {
		this.id = id;
		this.productId = productId;
		this.episodeNo = episodeNo;
		this.episodeId = episodeId;
		this.memberNo = memberNo;
		this.score = score;
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

	public int getEpisodeNo() {
		return episodeNo;
	}

	public void setEpisodeNo(int episodeNo) {
		this.episodeNo = episodeNo;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ScoreRequest [id=" + id + ", productId=" + productId + ", episodeNo=" + episodeNo + ", episodeId="
				+ episodeId + ", memberNo=" + memberNo + ", score=" + score + "]";
	}

}
