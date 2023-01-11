package com.vts.redis.model;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Student")
public class Student implements Serializable {
	
	private static final long serialVersionUID = -2826833026430986403L;
	
	@Id
	private int id;
	private String name;
	private String school;
	
	

}
