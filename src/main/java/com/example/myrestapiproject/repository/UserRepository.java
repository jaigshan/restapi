package com.example.myrestapiproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myrestapiproject.controller.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findByUserName(String userName);
	
}
