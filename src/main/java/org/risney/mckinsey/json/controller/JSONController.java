package org.risney.mckinsey.json.controller;

import java.util.ArrayList;
import java.util.List;

import org.risney.mckinsey.json.model.Category;
import org.risney.mckinsey.json.model.Video;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONController {

	public static final String JSON_STRING = "[{name:'Instant Queue',videos:[{'id':70111470,'title':'Die Hard','boxarts':[{width:150,height:200,url:'http://cdn-0.nflximg.com/images/2891/DieHard150.jpg'},{width:200,height:200,url:'http://cdn-0.nflximg.com/images/2891/DieHard200.jpg'}],'url':'http://api.netflix.com/catalog/titles/movies/70111470','rating':4.0,'bookmark':[]},{'id':654356453,'title':'Bad Boys','boxarts':[{width:200,height:200,url:'http://cdn-0.nflximg.com/images/2891/BadBoys200.jpg'},{width:150,height:200,url:'http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg'}],'url':'http://api.netflix.com/catalog/titles/movies/70111470','rating':5.0,'bookmark':[{id:432534,time:65876586}]}]},{name:'New Releases',videos:[{'id':65432445,'title':'The Chamber','boxarts':[{width:150,height:200,url:'http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg'},{width:200,height:200,url:'http://cdn-0.nflximg.com/images/2891/TheChamber200.jpg'}],'url':'http://api.netflix.com/catalog/titles/movies/70111470','rating':4.0,'bookmark':[]},{'id':675465,'title':'Fracture','boxarts':[{width:200,height:200,url:'http://cdn-0.nflximg.com/images/2891/Fracture200.jpg'},{width:150,height:200,url:'http://cdn-0.nflximg.com/images/2891/Fracture150.jpg'},{width:300,height:200,url:'http://cdn-0.nflximg.com/images/2891/Fracture300.jpg'}],'url':'http://api.netflix.com/catalog/titles/movies/70111470','rating':5.0,'bookmark':[{id:432534,time:65876586}]}]}]";

	/**
	 * Get a list of Categories
	 * 
	 * @return List<Category>
	 */

	public static List<Category> getCategories() {
		Gson gson = new Gson();
		List<Category> categories = gson.fromJson(JSON_STRING, new TypeToken<List<Category>>() {
		}.getType());
		return categories;
	}

	/**
	 * Look up a Category by name
	 * 
	 * @param categoryName
	 * @return Category
	 */
	public static Category getCategory(String categoryName) {
		List<Category> categories = getCategories();
		Category category = categories.stream().filter(c -> categoryName.equals(c.getName())).findAny().orElse(null);
		return category;
	}

	/**
	 * Get a list of videos by rating
	 * 
	 * @param _category
	 * @param rating
	 * @return List<Video>
	 */
	public static List<Video> getVideosByRating(Category _category, Double rating) {
		List<Video> ratedVideos = new ArrayList<Video>();

		Category category = getCategory(_category.getName());
		
		for (Video video : category.getVideos()) {

			if (rating.doubleValue() == video.getRating().doubleValue()) {
				ratedVideos.add(video);
			}
		}	 
		 
		return ratedVideos;
	}

	public static void main(String[] args) {
		List<Category> categories = getCategories();
		
		for (Category category : categories){
			System.out.println(category.getName());
		}
		
		Category nameSearchCategory = getCategory("Instant Queue");
		System.out.println(nameSearchCategory.getName());
		
		List<Video> videos = getVideosByRating(nameSearchCategory,new Double(5.0));
		for (Video video : videos){
			System.out.println(video.getTitle()+ " rating : "+ video.getRating());
		}
	}

}
