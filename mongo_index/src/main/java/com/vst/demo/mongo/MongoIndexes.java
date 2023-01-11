package com.vst.demo.mongo;


import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;


public class MongoIndexes {

	@Autowired
	MongoTemplate mongoTemplate;
	
	

	public void createIndex() {
	    mongoTemplate.indexOps("users").ensureIndex(new Index().on("name", Direction.ASC));
	    		
	}

	 
	
	
	}


