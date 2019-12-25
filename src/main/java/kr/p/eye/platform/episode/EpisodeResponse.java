package kr.p.eye.platform.episode;

import java.util.List;

public class EpisodeResponse {

	private int totalCount;
	private String title;
	private String content;
	private String writer;
	private List<Episode> episodes;

	public EpisodeResponse() {
	}

	public EpisodeResponse(int totalCount, String title, String content, String writer, List<Episode> episodes) {
		this.totalCount = totalCount;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.episodes = episodes;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	@Override
	public String toString() {
		return "EpisodeResponse [totalCount=" + totalCount + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", episodes=" + episodes + "]";
	}

}
