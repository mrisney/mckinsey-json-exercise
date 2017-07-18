package org.risney.mckinsey.json.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.risney.mckinsey.json.controller.JSONController;
import org.risney.mckinsey.json.model.Category;
import org.risney.mckinsey.json.model.Video;

public class TestJSONController {

	private List<Category> testCategories;

	@Before
	public void setUp() throws Exception {
		
		testCategories = JSONController.getCategories();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCategories() {
		assertEquals(testCategories.isEmpty(), false);

	}

	@Test
	public void testCategoryHasVideos() {
		Category category = JSONController.getCategory("Instant Queue");
		List<Video> videos = category.getVideos();
		assertEquals(videos.isEmpty(), false);
		assertEquals(videos.size(), 2);
	}

	@Test
	public void testRatedVideos() {

		// Getting category with the name "Instant Queue"
		Category category = JSONController.getCategory("Instant Queue");

		// look for videos that have a rating of 4.0
		Double testRating = new Double(4.0);
		List<Video> ratedVideos = JSONController.getVideosByRating(category, testRating);

		// assert that there is one video that has a rating of 4.0
		assertEquals(new Integer(ratedVideos.size()), new Integer(1));

		// assert that there is NO videos that have a rating of 3.0
		List<Video> falselyRatedVideos = JSONController.getVideosByRating(category, new Double(3.0));

		assertEquals(falselyRatedVideos.isEmpty(), true);

		for (Video vidoe : ratedVideos) {
			assertEquals(vidoe.getRating(), testRating);
		}
	}
}
