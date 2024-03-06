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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.log.reg.model.Register;
import com.log.reg.repo.RegisterRepo;
//import com.log.reg.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController
{
	
	@Autowired
	private RegisterRepo registerRepo;
	
	@PostMapping("/set")
	public ResponseEntity<?> setRegister(@RequestBody Register register)
	{
		if(registerRepo.existsByUsername(register.getUsername()))
		{
			return ResponseEntity.status(HttpStatus.FOUND).body("User Already Exists");
		}
		else
		{
			Register savedEntity = registerRepo.saveAndFlush(register);
			return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
		}
	}
	
	@GetMapping("/check")
	public ResponseEntity<?> RegisterId(@RequestParam String username,@RequestParam String password)
	{
		List<Register> register = registerRepo.findByUsernameAndPassword(username,password);
		return ResponseEntity.status(HttpStatus.OK).body(register);
	}
	
	
}
