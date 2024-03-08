package com.log.reg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.log.reg.model.AvailableGames;

public interface AvgameService {
	
	public AvailableGames setgamedata(AvailableGames avgames);
	public List<AvailableGames> getAllGameData();
}
