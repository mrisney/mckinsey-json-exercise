package org.risney.mckinsey.json.model;

import java.util.List;

public class Category {
	private String name;
	private List<Video> videos;
	
	
	 public Category(String name, List<Video> videos) {
		super();
		this.name = name;
		this.videos = videos;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}
