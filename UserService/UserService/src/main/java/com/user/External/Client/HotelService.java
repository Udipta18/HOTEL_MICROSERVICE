package com.user.External.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.Exception.CustomException;
import com.user.External.Entity.Hotel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "HOTEL-SERVICE/hotel")
public interface HotelService {
  
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAllHotel();
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Hotel> findHotelById(@PathVariable Integer id);
	
	 default ResponseEntity<Long> fallback(Exception e) {
	        throw new CustomException("Hotel Service is not available",
	                "UNAVAILABLE",
	                500);
	    }
}
