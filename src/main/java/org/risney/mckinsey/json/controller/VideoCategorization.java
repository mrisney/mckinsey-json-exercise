package org.risney.mckinsey.json.controller;
import java.util.List;

import org.risney.mckinsey.json.model.Category;
import org.risney.mckinsey.json.model.Video;

public interface VideoCategorization {
	
	public Category createCategory(String name);
	
	public Boolean deleteCategory(String name);
	
	public Boolean updateCategory(String name, String rename);
	
	public Category addVideos(Video video);
	
	public Category removeVideos(Video video);
	
	public List<Video> listVideos();
	

}
