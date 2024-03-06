package com.log.reg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.log.reg.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register,Integer> {

	List<Register> findByUsernameAndPassword(String username, String password);

	boolean existsByUsername(String username);



}
