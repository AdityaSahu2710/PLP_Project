package com.cg.show.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository  extends JpaRepository<ShowEntity, Integer>{
	public List<ShowEntity> findByMovieId(Integer movieId);
}
