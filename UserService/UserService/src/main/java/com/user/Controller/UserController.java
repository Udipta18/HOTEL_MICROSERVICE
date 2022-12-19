package com.user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.Entity.User;
import com.user.External.Entity.Hotel;
import com.user.External.Entity.Rating;
import com.user.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<User>(saveUser,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}
	
	@GetMapping("/getAllHotel")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> allHotel = userService.getAllHotesl();
		return new ResponseEntity<List<Hotel>>(allHotel,HttpStatus.OK);
	}
	
	
	@GetMapping("/getByRating/{rating}")
	public ResponseEntity<List<Hotel>> getHotelByRating(@PathVariable Double rating){
		List<Hotel> hotelByRating = userService.getHotelByRating(rating);
		return new ResponseEntity<List<Hotel>>(hotelByRating,HttpStatus.OK);
	}
	
	
	@PostMapping("/giveRating")
	public ResponseEntity<Rating> saveHotelRatingBtUser(@RequestBody Rating rating){
		Rating saveHotelRatingByUser = userService.saveHotelRatingByUser(rating);
		return new ResponseEntity<Rating>(saveHotelRatingByUser,HttpStatus.OK);
		
	}

}
