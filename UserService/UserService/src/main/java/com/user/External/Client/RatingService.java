package com.user.External.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.Exception.CustomException;
import com.user.External.Entity.Rating;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "RATING-SERVICE/rating")
public interface RatingService {
  
	@GetMapping("/get/{rating}")
	public ResponseEntity<List<Rating>> getHotelByRating(@PathVariable Double rating);
	
	@PostMapping("/save")
	public ResponseEntity<Rating> saveHotelRating(@RequestBody Rating rating);
	
	
	 default ResponseEntity<Long> fallback(Exception e) {
	        throw new CustomException("Rating Service is not available",
	                "UNAVAILABLE",
	                500);
	    }
}
