package com.cg.consumer.model;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Show {
	@NotBlank(message = "showId is mandatory")
	@NotNull(message = "showId is mandatory")
	private Integer showId;
	
	@NotBlank(message = "showStartTime is mandatory")
	@NotNull(message = "showStartTime is mandatory")
	private float showStartTime;
	
	@NotBlank(message = "showEndTime is mandatory")
	@NotNull(message = "showEndTime is mandatory")
	private float showEndTime;
	
	@NotBlank(message = "seats is mandatory")
	@NotNull(message = "seats is mandatory")
	private Integer seats;
	
	@NotBlank(message = "showName is mandatory")
	@NotNull(message = "showName is mandatory")
	private String showName;
	
	@NotBlank(message = "movieId is mandatory")
	@NotNull(message = "movieId is mandatory")
	private Integer movieId;
	
	@NotBlank(message = "theatreId is mandatory")
	@NotNull(message = "theatreId is mandatory")
	private Integer theatreId;

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public float getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(float showStartTime) {
		this.showStartTime = showStartTime;
	}

	public float getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(float showEndTime) {
		this.showEndTime = showEndTime;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", seats=" + seats + ", showName=" + showName + ", movieId=" + movieId + ", theatreId=" + theatreId
				+ "]";
	}
	
	

}
