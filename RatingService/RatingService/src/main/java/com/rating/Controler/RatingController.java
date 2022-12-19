package com.rating.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rating.Entity.Rating;
import com.rating.Service.RatingService;

@Controller
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/get/{rating}")
	public ResponseEntity<List<Rating>> getHotelByRating(@PathVariable Double rating){
		
		List<Rating> findHotelByRating = ratingService.findHotelByRating(rating);
		return new ResponseEntity<List<Rating>>(findHotelByRating,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Rating> saveHotelRating(@RequestBody Rating rating){
		Rating saveRatingOfHotel = ratingService.saveRatingOfHotel(rating);
		return new ResponseEntity<Rating>(saveRatingOfHotel,HttpStatus.OK);
		
	}
}
