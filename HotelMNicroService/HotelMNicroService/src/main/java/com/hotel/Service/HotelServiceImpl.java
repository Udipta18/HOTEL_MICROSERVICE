package com.hotel.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.Entity.Hotel;
import com.hotel.Repository.HotelRepo;


@Service
public class HotelServiceImpl implements HotelService {
	
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel createHotelEntity(Hotel hotel) {
		
		Hotel savedHotel = hotelRepo.save(hotel);
		
		return savedHotel;
	}

	@Override
	public List<Hotel> getAllDetails() {
		List<Hotel> findAllHotel = hotelRepo.findAll();
		return findAllHotel;
	}

	@Override
	public Hotel findById(Integer id) {
		Optional<Hotel> findById = hotelRepo.findById(id);
		return findById.get();
	}

}
