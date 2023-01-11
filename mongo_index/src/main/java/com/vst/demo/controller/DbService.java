package com.vst.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.vst.demo.model.DbSeq;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


@Service
public class DbService {
	
	 @Autowired
	    private MongoOperations mongoOperations;
	
	 public int getSequenceNumber(String sequenceName) {
		 
		 // by this we get sequence name or number
		 Query query = new Query(Criteria.where("id").is(sequenceName));
		 // it will update the sequence no. by 1
		 Update update =new Update().inc("seq", 1);
		 
		DbSeq counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSeq.class);
		 
		 return !Objects.isNull(counter) ? counter.getSeq() : 1;

}
}
