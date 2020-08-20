package com.example.flowerservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flowerservice.flower.Flower;
/**
 * http://localhost:8080/flower-service/flowers
 * @author agridin74
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/flowers")
public class FlowerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowerServiceApplication.class, args);
	}
	
	//инициализируем 
	private List<Flower> flowerList = Arrays.asList(
		new Flower(1L,"Owner1", "Flower1"),
		new Flower(2L,"Owner2", "Flower2"),
		new Flower(3L,"Owner3", "Flower3")
			);
	
	/**
	 * список 
	 * @return
	 */
	@GetMapping("")
	public List<Flower> findAllFlowers(){
		return flowerList;
	}
	
	@GetMapping("/{flowerId}")
	public Flower findFlower(@PathVariable Long flowerId) {
		return flowerList.stream().filter(b -> b.getId().equals(flowerId)).findFirst().orElse(null);
	}

}
