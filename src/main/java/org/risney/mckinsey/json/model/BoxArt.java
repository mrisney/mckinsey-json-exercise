package org.risney.mckinsey.json.model;

public class BoxArt {

	private int height;
	private int width;
	private String url;
	
	
	public BoxArt(int height, int width, String url) {
		super();
		this.height = height;
		this.width = width;
		this.url = url;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
