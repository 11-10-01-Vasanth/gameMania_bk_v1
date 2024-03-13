package com.log.reg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.log.reg.model.AvailableGames;

public interface AvgameService {
	
	public AvailableGames setgamedata(AvailableGames avgames);
	public List<AvailableGames> getAllGameData();
	public AvailableGames updateProduct(int agid, String gametitle, String discount, String price, String discountprice, String imgUrl);
}
