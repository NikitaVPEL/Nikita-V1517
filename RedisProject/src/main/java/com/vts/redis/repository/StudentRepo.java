package com.vts.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.vts.redis.model.Student;

@Repository
public class StudentRepo {

	private static final String HASH_KEY = "Student";
	
	@Autowired
	RedisTemplate redisTemplate;
	
	public Student save(Student student) {
		 redisTemplate.opsForHash().put(HASH_KEY,student.getId(),student);
		return student;
	}
	
	public List<Student> getAll(){
		return  redisTemplate.opsForHash().values(HASH_KEY);
	}
	
	public Object findStudentById(int id) {
	return 	redisTemplate.opsForHash().get(HASH_KEY, id);
	
//		String student=redisTemplate.opsForHash().get(HASH_KEY, id).toString();	
//		return student;
	}
	
	public String deleteById(int id) {
		 redisTemplate.opsForHash().delete(HASH_KEY, id);
		return "Student Removed";
	}
}
