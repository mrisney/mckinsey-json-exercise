package org.risney.mckinsey.json.model;

import java.util.List;

public class Video {
	private int id;
	private String title;
	private List<BoxArt> boxArts;
	private List<BookMark> bookmarks;
	private Double rating;
	
	public Video(int id, String title, List<BoxArt> boxArts) {
		super();
		this.id = id;
		this.title = title;
		this.boxArts = boxArts;
	}
	


	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<BoxArt> getBoxArts() {
		return boxArts;
	}
	public void setBoxArts(List<BoxArt> boxArts) {
		this.boxArts = boxArts;
	}
	
	public List<BookMark> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(List<BookMark> bookmarks) {
		this.bookmarks = bookmarks;
	}
}
