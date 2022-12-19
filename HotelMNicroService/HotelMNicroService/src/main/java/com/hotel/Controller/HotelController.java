package com.hotel.Controller;

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

import com.hotel.Entity.Hotel;
import com.hotel.Service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	
	@Autowired
	private HotelService hotelService;
	
	
	
	@PostMapping("/create")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		
		Hotel createHotelEntity = hotelService.createHotelEntity(hotel);
		return new ResponseEntity<Hotel>(createHotelEntity,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> allDetails = hotelService.getAllDetails();
	    return new ResponseEntity<List<Hotel>>(allDetails,HttpStatus.OK);	
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Hotel> findHotelById(@PathVariable Integer id){
		Hotel findById = hotelService.findById(id);
		return new ResponseEntity<Hotel>(findById,HttpStatus.OK);
	}
}
