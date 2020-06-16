package com.cg.show.exceptions;

public class ShowExceptions extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer showId;
	private Integer theaterId;
	private Integer movieId;
	public ShowExceptions(Integer showId,Integer theaterId,Integer movieId) {
		super();
		this.showId = showId;
		this.movieId=movieId;
		this.theaterId=theaterId;
	}
	public ShowExceptions(Integer showId) {
		super();
		this.showId = showId;
	}

	@Override
	public String toString() {
		String s="";
		if (showId == 0 || showId==null)
			s="showId cannot be 0 or Null";
		else if(showId.toString().length()<8)
			s= "showId should be min of length of 8";
		else if (!showId.toString().equals(movieId.toString()+theaterId.toString()))
			s="showId should be combination of movieId and theaterId";
		
		return s;
	}

}