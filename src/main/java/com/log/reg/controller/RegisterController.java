package com.log.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.reg.model.Register;
import com.log.reg.repo.RegisterRepo;
import com.log.reg.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController
{
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private RegisterRepo registerRepo;
	
	@PostMapping("/set")
	public ResponseEntity<?> setRegister(@RequestBody Register register)
	{
		Register savedEntity = registerService.setRegister(register);
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getRegisterData(@PathVariable int id)
	{
		Register getData = registerRepo.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(getData);
	}
}
