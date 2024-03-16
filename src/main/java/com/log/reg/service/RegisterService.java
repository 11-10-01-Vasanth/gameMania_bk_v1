package com.log.reg.service;

import com.log.reg.model.Register;

public interface RegisterService {
	boolean setRegister(Register register);
	boolean checkData(String username, String password);
}
