package com.junitTesting.repostiory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.junitTesting.model.User;

public interface UserRepo extends MongoRepository<User, Integer>{
	
	List<User> findByAddress(String address);
}
