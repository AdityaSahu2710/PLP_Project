package com.cg.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.consumer.model.Show;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate rest;
	String result;

	// http://localhost:4000/show/create
	@PostMapping("/show/create")
	public String createShow(@RequestBody Show show) {
		String response = rest.postForObject("http://ShowMS/createshow", show, String.class);
		return response;

	}

	// http://localhost:4000/show/<enterid>
	@GetMapping("/show/{showId}")
	public String readShow(@PathVariable Integer showId) {
		String show = rest.getForObject("http://ShowMS/readshow/" + showId, String.class);
		return show;
	}

	// http://localhost:4000/show/update/<enterid>
	@PutMapping("/show/update/{showId}")
	public String updateShow(@PathVariable Integer showId, @RequestBody Show show) {
		String shows = rest.getForObject("http://ShowMS/updateshow/" + showId, String.class);
		if (shows == null || shows.equals(""))
			return "Show Updation UnSuccessful";
		else {
			rest.put("http://ShowMS/showupdate/" + showId, show, String.class);
			return "Show Updation Successful";
		}
	}

	// http://localhost:4000/show/delete/<enterid>
	@DeleteMapping("/show/delete/{showId}")
	public String deleteShow(@PathVariable Integer showId) {
		String show = rest.getForObject("http://ShowMS/deleteshow/" + showId, String.class);
		if (show == null || show.equals("")) {
			return "Show Deletion unsuccessful";
		} else {
			rest.delete("http://ShowMS/deleteShow/" + showId, showId);
			return "Show Deletion successful";
		}

	}
	
	// http://localhost:4000/show/showbymovieid/{movieId}"
	@GetMapping("/show/showbymovieid/{movieId}")
	public String readShowByMovieId(@PathVariable Integer movieId) {
		String show = rest.getForObject("http://ShowMS/readshowbymovieid/" + movieId, String.class);
		return show;
	}
}
