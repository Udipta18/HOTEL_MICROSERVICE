package com.rating.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.Entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer> {

	
	 List<Rating> findByRating(Double id);
}
