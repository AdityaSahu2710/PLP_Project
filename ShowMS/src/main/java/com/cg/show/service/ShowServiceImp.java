package com.cg.show.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.show.DAO.ShowEntity;
import com.cg.show.DAO.ShowRepository;
import com.cg.show.model.Show;

@Service
public class ShowServiceImp implements ShowService {

	@Autowired
	ShowRepository repository;

	@Override
	public Boolean createShow(Show show) {
		if (show.getShowId().toString().length() < 8)
			return null;
		ShowEntity showEntity = new ShowEntity();
		showEntity.setMovieId(show.getMovieId());
		showEntity.setSeats(show.getSeats());
		showEntity.setShowEndTime(show.getShowEndTime());
		showEntity.setShowId(show.getShowId());
		showEntity.setShowName(show.getShowName());
		showEntity.setShowStartTime(show.getShowStartTime());
		showEntity.setTheaterId(show.getTheatreId());
		repository.save(showEntity);
		return true;

	}

	@Override
	public String readShow(Integer showId) {
		Optional<ShowEntity> showEntity = repository.findById(showId);
		if (showEntity.isPresent()) {
			ShowEntity showOptional = showEntity.get();
			Show show = new Show();
			show.setMovieId(showOptional.getMovieId());
			show.setSeats(showOptional.getSeats());
			show.setShowEndTime(showOptional.getShowEndTime());
			show.setShowId(showOptional.getShowId());
			show.setShowName(showOptional.getShowName());
			show.setShowStartTime(showOptional.getShowStartTime());
			show.setTheatreId(showOptional.getTheaterId());
			return show.toString();
		}

		return "ShowId not found";

	}

	@Override
	public Boolean updateShow(Integer showId, Show newShow) {
		if (readShow(showId).equals("ShowId not found"))
			return false;
		Optional<ShowEntity> showEntity = repository.findById(showId);
		ShowEntity showOptional = showEntity.get();
		showOptional.setMovieId(newShow.getMovieId());
		showOptional.setSeats(newShow.getSeats());
		showOptional.setShowEndTime(newShow.getShowEndTime());
		showOptional.setShowId(newShow.getShowId());
		showOptional.setShowName(newShow.getShowName());
		showOptional.setShowStartTime(newShow.getShowStartTime());
		showOptional.setTheaterId(newShow.getTheatreId());
		repository.saveAndFlush(showOptional);
		return true;
	}

	@Override
	public Boolean deleteShow(Integer showId) {
		Boolean flag;
		try {
			repository.findById(showId);
			repository.deleteById(showId);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	public List<Show> readShowByMovieId(Integer movieId) {
		List<ShowEntity> showEntity = repository.findByMovieId(movieId);
		List<Show> list = new ArrayList<Show>();
		for (ShowEntity s : showEntity) {
			Show show = new Show();
			show.setMovieId(s.getMovieId());
			show.setSeats(s.getSeats());
			show.setShowEndTime(s.getShowEndTime());
			show.setShowId(s.getShowId());
			show.setShowName(s.getShowName());
			show.setShowStartTime(s.getShowStartTime());
			show.setTheatreId(s.getTheaterId());
			list.add(show);
		}
		return list;
	}
}
