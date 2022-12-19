package com.rating.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Rating {
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ratingId;
	
	private Integer hotelId;
	
	
	private Double rating;
}
