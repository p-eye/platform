package kr.p.eye.platform.episodeimage;

public class EpisodeImage {

	private int id;
	private int episodeInfoId;
	private int fileId;
	private String type;

	public EpisodeImage() {
	}

	public EpisodeImage(int id, int episodeInfoId, int fileId, String type) {
		this.id = id;
		this.episodeInfoId = episodeInfoId;
		this.fileId = fileId;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEpisodeInfoId() {
		return episodeInfoId;
	}

	public void setEpisodeInfoId(int episodeInfoId) {
		this.episodeInfoId = episodeInfoId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EpisodeImage [id=" + id + ", episodeInfoId=" + episodeInfoId + ", fileId=" + fileId + ", type=" + type
				+ "]";
	}

}
