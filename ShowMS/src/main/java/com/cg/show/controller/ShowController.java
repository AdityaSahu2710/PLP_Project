package com.cg.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.show.exceptions.ShowExceptions;
import com.cg.show.model.Show;
import com.cg.show.service.ShowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ShowController {
	@Autowired
	ShowService service;

	@PostMapping("/createshow") 
	@HystrixCommand(fallbackMethod = "getFallbackMethod")
	public String createShow(@RequestBody Show show) {
		try {
			if (show.getShowId() == 0 || show.getShowId() == null)
				throw new ShowExceptions(show.getShowId(), show.getTheatreId(), show.getMovieId());
			else if (show.getShowId().toString().length() < 8) {
				throw new ShowExceptions(show.getShowId());
			} else if (!show.getShowId().toString()
					.equals(show.getMovieId().toString() + show.getTheatreId().toString()))
				throw new ShowExceptions(show.getShowId(), show.getTheatreId(), show.getMovieId());
			else {
				if (service.createShow(show))
					return "Create Successfully";
				return "Create Unsuccessful";
			}

		} catch (ShowExceptions e) {
			return e.toString();
		}

	}

	public String getFallbackMethod(@RequestBody Show show) {
		return "No Value Detected";
	}

	@GetMapping("/readshow/{showId}")
	public String readShow(@PathVariable Integer showId) {
		try {
			if (showId == 0 || showId == null)
				throw new ShowExceptions(showId);
			else if (showId.toString().length() < 8) {
				throw new ShowExceptions(showId);
			} else {
				if (service.readShow(showId).equals("ShowId not found"))
					return "ShowId not found";
				else
					return service.readShow(showId);

			}

		} catch (ShowExceptions e) {
			return e.toString();
		}

	}

	@PutMapping("/updateshow/{showId}")
	public String updateShow(@PathVariable Integer showId, @RequestBody Show show) {
		try {
			if (show.getShowId() == 0 || show.getShowId() == null)
				throw new ShowExceptions(show.getShowId(), show.getTheatreId(), show.getMovieId());
			else if (show.getShowId().toString().length() < 8) {
				throw new ShowExceptions(show.getShowId());
			} else if (!show.getShowId().toString()
					.equals(show.getMovieId().toString() + show.getTheatreId().toString()))
				throw new ShowExceptions(show.getShowId(), show.getTheatreId(), show.getMovieId());
			else {
				if (service.updateShow(showId, show))
					return "Update Successfully";
				return "Update Unsuccessful";
			}

		} catch (ShowExceptions e) {
			return e.toString();
		}
	}

	@DeleteMapping("/deleteshow/{showId}")
	public String deleteShow(@PathVariable Integer showId) {
		try {
			String ss=readShow(showId);
			if (showId == 0 || showId == null)
				throw new ShowExceptions(showId);
			else if (showId.toString().length() < 8) {
				throw new ShowExceptions(showId);
			}
			else if (ss.equals("ShowId not found")) {
				return "Delete Unsuccessful";
				
			}
			else {
				if (service.deleteShow(showId))
					return "Delete Successfully";
				return "Delete Unsuccessful";

			}
		} catch (ShowExceptions e) {
			return e.toString();
		}

	}

	@GetMapping("/readshowbymovieid/{movieId}")
	public String readShowByMovieId(@PathVariable Integer movieId) {
		if (movieId == 0 || movieId == null) {
			return "movieId can not be null";
		} else if (movieId.toString().length() < 4) {
			return "movieId can not less than 4";
		} else {
			if (service.readShowByMovieId(movieId).size() == 0)
				return "movieId not found";
			else
				return service.readShowByMovieId(movieId).toString();

		}
	}
}