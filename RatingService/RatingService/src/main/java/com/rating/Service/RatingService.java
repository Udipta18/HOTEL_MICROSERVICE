package com.rating.Service;

import java.util.List;

import com.rating.Entity.Rating;

public interface RatingService {

	List<Rating> findHotelByRating(Double id);
	
	Rating saveRatingOfHotel(Rating rating);
}
