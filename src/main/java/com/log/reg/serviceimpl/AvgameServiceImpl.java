package com.log.reg.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.log.reg.model.AvailableGames;
import com.log.reg.repo.AvgameRepo;
import com.log.reg.service.AvgameService;

@Service
public class AvgameServiceImpl implements AvgameService{

	@Autowired
	private AvgameRepo avRepo; 
	
	@Override
	public AvailableGames setgamedata(AvailableGames avgames) {
		AvailableGames savedEntity = avRepo.save(avgames);
		return savedEntity;
	}

	@Override
	public List<AvailableGames> getAllGameData(){
		List<AvailableGames> savedEntity = avRepo.findAll();
		return savedEntity;
	}
	
}
