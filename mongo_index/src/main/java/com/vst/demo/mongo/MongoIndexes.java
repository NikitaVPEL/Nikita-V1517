package com.vst.demo.mongo;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.ExplainVerbosity;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.Connection;

public class MongoIndexes {
	
	public String mongoIndexes() {
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase database = mongoClient.getDatabase("test");
		System.out.println(database);
		MongoCollection<Document> collection = database.getCollection("DB");
		collection.find().explain(ExplainVerbosity.ALL_PLANS_EXECUTIONS);
        System.out.println(collection);
        return "connection established:";

	}
	}


