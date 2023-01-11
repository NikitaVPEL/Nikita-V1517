package com.vst.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vst.demo.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {

	
 public	List<User> 	findByName(String name);
 
 
  @Query(value =  "{'add': ?0}", fields = "{'name':1}")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  List<User> findByAdd(String add);
  
  @Query("{'name':?0, 'add':?1}")
  List<User> findByNameAndAdd(String name, String add);
  
 
}
