package com.vst.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "DB")
public class User {
	
	@Transient
	public static final String SEQUENCE_NAME = "charger";
	
	
	
	@MongoId
	int id;
	String name;
	String phone;
	String add;
	String age;
	String gender;
	

}
