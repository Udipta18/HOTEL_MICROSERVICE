package com.hotel.Service;

import java.util.List;

import com.hotel.Entity.Hotel;

public interface HotelService {

	Hotel createHotelEntity(Hotel hotel);
	
	List<Hotel> getAllDetails();
	
	Hotel findById(Integer id);
	
}
