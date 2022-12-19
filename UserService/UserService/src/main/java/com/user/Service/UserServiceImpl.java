package com.user.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.Entity.User;
import com.user.External.Client.HotelService;
import com.user.External.Client.RatingService;
import com.user.External.Entity.Hotel;
import com.user.External.Entity.Rating;
import com.user.Repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private HotelService hotelService;
	
	
	@Autowired
	private RatingService ratingService;

	@Override
	public User saveUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUser() {
		 List<User> findAllUser = userRepo.findAll();
		return findAllUser;
	}

	@Override
	public List<Hotel> getAllHotesl() {
		ResponseEntity<List<Hotel>> allHotel = hotelService.getAllHotel();
		
		return allHotel.getBody();
	}

	@Override
	public List<Hotel> getHotelByRating(Double rating) {
		ResponseEntity<List<Rating>> hotelByRating = ratingService.getHotelByRating(rating);
	      List<Rating> body = hotelByRating.getBody();
	      List<Hotel> hotelList=new ArrayList<>();
	      for(Rating li:body) {
	    	  ResponseEntity<Hotel> findHotelById = hotelService.findHotelById(li.getHotelId());
	    	  Hotel hotelEntity = findHotelById.getBody();
	    	  hotelList.add(hotelEntity);
	      }
	      
	      return hotelList;
	}

	@Override
	public Rating saveHotelRatingByUser(Rating rating) {
		 ResponseEntity<Rating> saveHotelRating = ratingService.saveHotelRating(rating);
		return saveHotelRating.getBody();
	}

}
