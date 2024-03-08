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
import com.log.reg.model.ImageStore;
import com.log.reg.repo.ImageRepo;
import com.log.reg.service.AvgameService;


@RestController
@RequestMapping("/avgames")
public class AgController {

	
	@Autowired
    private ImageRepo imageRepo;
	
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
	
	
	 @GetMapping("/getImage")
	    public ResponseEntity<?> getAllImages() {
	        List<ImageStore> images = imageRepo.findAll();
	        return ResponseEntity.ok(images);
	    }

	    @PostMapping("/setImage")
	    public ResponseEntity<?> createImage(@RequestBody ImageStore image) {
	        ImageStore savedImage = imageRepo.save(image);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedImage);
	    }
	    
	    @PostMapping("/setImage/{id}")
	    public ResponseEntity<ImageStore> setImage(@PathVariable int id) {
	        ImageStore savedImage = imageRepo.findById(id);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedImage);
	    }
}
