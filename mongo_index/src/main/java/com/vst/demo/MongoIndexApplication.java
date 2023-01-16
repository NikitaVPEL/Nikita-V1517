package com.vst.demo;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class MongoIndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoIndexApplication.class, args);
		
	
	}

}
