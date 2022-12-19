package com.rating.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.Entity.Rating;
import com.rating.Repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public List<Rating> findHotelByRating(Double id) {
		List<Rating> findByRating = ratingRepo.findByRating(id);
		return findByRating;
	}

	@Override
	public Rating saveRatingOfHotel(Rating rating) {
		Rating savedRating = ratingRepo.save(rating);
		return savedRating;
	}

}
