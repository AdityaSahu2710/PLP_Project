package com.cg.consumer.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="shows")
public class ShowEntity {
	
	@Id
	@Column(name ="showid")
	private Integer showId;
	
	@Column(name ="showstarttime")
	private float showStartTime;
	
	@Column(name ="showendtime")
	private float showEndTime;
	
	@Column(name ="seats")
	private Integer seats;
	
	@Column(name ="showname")
	private String showName;
	
	@Column(name ="movieid")
	private Integer movieId;
	
	@Column(name ="theaterid")
	private Integer theaterId;

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

	public Integer getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}

	@Override
	public String toString() {
		return "ShowEntity [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", seats=" + seats + ", showName=" + showName + ", movieId=" + movieId + ", theaterId=" + theaterId
				+ "]";
	}
	
	public ShowEntity() {
		super();
	}
	
}
