package com.apiGateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
  
	@GetMapping("/userServiceFallBack")
    public String userServiceFallBack() {
        return "User Service is down!";
    }

    @GetMapping("/hotelServiceFallBack")
    public String hotelServiceFallBack() {
        return "Hotel Service is down!";
    }

    @GetMapping("/ratingServiceFallBack")
    public String ratingServiceFallBack() {
        return "Rating Service is down!";
    }
}
