package kr.p.eye.platform.episode;

import java.time.LocalDateTime;

public class EpisodeRequest {

	private int id;
	private int productId;
	private String episodeName;
	private String writer;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;

	public EpisodeRequest() {
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
	}

	public EpisodeRequest(int id, int productId, String episodeName, String writer, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		this.id = id;
		this.productId = productId;
		this.episodeName = episodeName;
		this.writer = writer;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
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

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
		return "EpisodeRequest [id=" + id + ", productId=" + productId + ", episodeName=" + episodeName + ", writer="
				+ writer + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

}
