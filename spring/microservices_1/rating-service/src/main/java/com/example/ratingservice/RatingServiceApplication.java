package com.example.ratingservice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingservice.rating.Rating;
/**
 * //http://localhost:8080/rating-service/ratings/all
 * @author agridin74
 *
 */

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/ratings")
public class RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}
	
	private List<Rating> ratingList = Arrays.asList(
			new Rating(1L, 1L, 2),
			new Rating(2L, 1L, 3),
			new Rating(3L, 2L, 4),
			new Rating(4L, 2L, 5),
			new Rating(5L, 3L, 2),
			new Rating(6L, 4L, 3)
			);
	
	@GetMapping("")
	public List<Rating> findRatingsByFlowerId(@RequestParam Long flowerId){
		return flowerId == null || flowerId.equals(0L) ? Collections.emptyList() : ratingList.stream()
				.filter(r -> r.getFlowerId().equals(flowerId)).collect(Collectors.toList());
	}
	
	@GetMapping("/all")
	public List<Rating> findAllRatings(){
		return ratingList;
	}

}
