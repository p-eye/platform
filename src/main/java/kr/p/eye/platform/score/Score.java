package kr.p.eye.platform.score;

public class Score {

	private int id;
	private int episodeId;
	private int memberNo;
	private double score;

	public Score() {
	}

	public Score(int id, int episodeId, int memberNo, double score) {
		this.id = id;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", episodeId=" + episodeId + ", memberNo=" + memberNo + ", score=" + score + "]";
	}

}
