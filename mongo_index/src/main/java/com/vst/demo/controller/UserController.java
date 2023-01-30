package com.vst.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.SortOrder;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.hibernate.result.Output;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.demo.model.User;
import com.vst.demo.repository.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	DbService dbser;

	
	
	@Autowired
	MongoTemplate mongoTemplate;

	
    


	@GetMapping("getid/{id}")
	public Optional<User> getid(@PathVariable int id) {

	 return repo.findById(id);
		
	}
	
	@PostMapping("db")
	public boolean save(@RequestBody User user) {
		user.setId(dbser.getSequenceNumber(User.SEQUENCE_NAME));
		 repo.save(user);
		 return true;
	}
			
	@GetMapping("db")
		public Optional<User> read(@RequestParam("id") int id) {
		return	repo.findById(id);
			
		}
	
	@PostMapping("multiple")
	public boolean multiple() {
		User user = new User();
		
		for(int i=1; i<10000; i++) {
			user.setName("nikita" + i);
			user.setPhone("876524657"+i);
			user.setAdd("nagpur"+i);
			save(user);
			
		}
		
		return true;
	}
	
	@GetMapping("name")
	public List<User> findName(@RequestParam("name") String name) {
		return repo.findByName(name);
	}
	
	@GetMapping("/user/{phone}")
	List<User> findAll(@PathVariable(value = "name") String phone){
		Query query=new Query();
		query.addCriteria(Criteria.where("phone").is(phone));
		
	return	mongoTemplate.find(query, User.class);
		
	}
	
	@GetMapping("add/{add}")
	List<User> findAdd(@PathVariable String add){
		
		
	return	repo.findByAdd(add);
		
	}
	
	
//	@GetMapping("add/{add}")
//	List<User> findAddress(@PathVariable String add){
//		
//		//match operation 
//		MatchOperation matchOperation=Aggregation.match(new Criteria("add").is(add));
//		//sort operation 
//		SortOperation sortOperation= Aggregation.sort(Sort.by(Sort.Direction.DESC,"age"));
//		//aggregation 
//		Aggregation aggregation=Aggregation.newAggregation(matchOperation,sortOperation);
//		AggregationResults output =mongoTemplate.aggregate(aggregation, "user", User.class);
//		
//		
//		return output.getMappedResults();
//		
//	}
		@GetMapping("name/{name}/{add}")
		List<User> findNameAndAdd(@PathVariable String name, @PathVariable String add){
			return repo.findByNameAndAdd(name, add);
			
		
	}
		
//		@GetMapping("tt")
//		public User findByAge(@RequestParam("age") String age){
//			
//			System.out.println(age);
//			
//			MongoClient mongoClient2 = new MongoClient();
//			
//			MongoTemplate mongoTemplate= new MongoTemplate(mongoClient2, "test");
//			Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("age").gt(18)),Aggregation.group("gender").count().as("count"));
//			
//			System.out.println(aggregation);
//			
//			System.out.println(aggregation.toString());
//			
//			System.out.println(aggregation.getOptions());
//			
//			AggregationResults<User>results = mongoTemplate.aggregate(aggregation, "DB",User.class);
//			
//			List<User> resultList = results.getMappedResults();
//			for(User doc : resultList) {
//				System.out.println(doc);	
//			}
//			System.out.println(results.getUniqueMappedResult());
		//	return results.getUniqueMappedResult();
		//	}
	
		
}

