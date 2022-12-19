package com.user.Service;

import java.util.List;

import com.user.Entity.User;
import com.user.External.Entity.Hotel;
import com.user.External.Entity.Rating;

public interface UserService {
  
	User saveUser(User user);
	
	
	List<User> getAllUser();
	
	
	List<Hotel> getAllHotesl();
	
	List<Hotel> getHotelByRating(Double rating);
	
	Rating saveHotelRatingByUser(Rating rating);
}
