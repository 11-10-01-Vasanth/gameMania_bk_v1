package com.log.reg.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.reg.model.Register;
import com.log.reg.repo.RegisterRepo;
import com.log.reg.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepo registerRepo;
	
	@Override
	public Register setRegister(Register register) 
	{
		Register reg = registerRepo.saveAndFlush(register);
		return reg;
	}

}
