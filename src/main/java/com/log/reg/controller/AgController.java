package com.log.reg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.log.reg.model.AvailableGames;
import com.log.reg.repo.AvgameRepo;
import com.log.reg.service.AvgameService;


@RestController
@RequestMapping("/avgames")
public class AgController {

	
	@Autowired
    private AvgameRepo avRepo;
	
	@Autowired 
	private AvgameService avService;
	
	@PostMapping("/setgamedata")
	public ResponseEntity<?> setgamedata(@RequestBody AvailableGames avgames) 
	{
		AvailableGames av = avService.setgamedata(avgames);
		return ResponseEntity.status(HttpStatus.OK).body(av);
	}
	
	@GetMapping("/getAllGameData")
	public ResponseEntity<?> getAllGameData()
	{
		List<AvailableGames> savedEntity = avService.getAllGameData();
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestParam int agid, @RequestParam String gametitle, @RequestParam String discount, @RequestParam String price, @RequestParam String discountprice, @RequestParam String imgUrl)
	{
		AvailableGames savedEntity = avService.updateProduct(agid, gametitle, discount, price, discountprice, imgUrl);
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	
	@GetMapping("/list/{page}/{size}")
	public ResponseEntity<?> getPostsPage(@PathVariable int page, @PathVariable int size){
		PageRequest.of(2, 3);
		
//		List<Post> posts = postRepo.findAll(PageRequest.of(page, size)).toList();
		List<AvailableGames> posts = avRepo.findAll(
				PageRequest.of(
						page, size, 
						Sort.by("agid").ascending()
						)).toList();
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(posts);
		
	}
	
	
}
