package com.cg.show.service;

import java.util.List;

import com.cg.show.model.Show;

 
public interface ShowService {
	public Boolean createShow(Show show);
	public String readShow(Integer showId);
	public Boolean updateShow(Integer showId,Show show);
	public Boolean deleteShow(Integer showId);
	public List<Show> readShowByMovieId(Integer movieId);
}
