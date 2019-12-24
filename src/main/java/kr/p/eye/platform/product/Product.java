package kr.p.eye.platform.product;

public class Product {

	private int productId;
	private int categoryId;
	private String title;
	private String writer;
	private String episodeName;
	private int viewCnt;
	private double starScore;
	private int starScoreCount;

	public Product() {
	}

	public Product(int productId, int categoryId, String title, String writer, String episodeName, int viewCnt,
			double starScore, int starScoreCount) {
		this.productId = productId;
		this.categoryId = categoryId;
		this.title = title;
		this.writer = writer;
		this.episodeName = episodeName;
		this.viewCnt = viewCnt;
		this.starScore = starScore;
		this.starScoreCount = starScoreCount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public double getStarScore() {
		return starScore;
	}

	public void setStarScore(double starScore) {
		this.starScore = starScore;
	}

	public int getStarScoreCount() {
		return starScoreCount;
	}

	public void setStarScoreCount(int starScoreCount) {
		this.starScoreCount = starScoreCount;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", title=" + title + ", writer="
				+ writer + ", episodeName=" + episodeName + ", viewCnt=" + viewCnt + ", starScore=" + starScore
				+ ", starScoreCount=" + starScoreCount + "]";
	}

}
