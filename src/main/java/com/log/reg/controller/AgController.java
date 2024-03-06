package com.log.reg.controller;

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

import com.log.reg.model.AvailableGames;
import com.log.reg.repo.AvgameRepo;


@RestController
@RequestMapping("/avgames")
public class AgController {

	@Autowired
	private AvgameRepo avRepo;
	
	@PostMapping("/setgamedata")
	public ResponseEntity<?> setgamedata(@RequestBody AvailableGames avgames) 
	{
		AvailableGames savedEntity = avRepo.save(avgames);
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	
	@GetMapping("/getgamedata/{id}")
	public ResponseEntity<?> getgamedata(@PathVariable int id)
	{
		AvailableGames savedEntity = avRepo.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	
	@GetMapping("/getgamedata")
	public ResponseEntity<?> getgamedata(@RequestBody AvailableGames avgames)
	{
		List<AvailableGames> savedEntity = avRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
}
