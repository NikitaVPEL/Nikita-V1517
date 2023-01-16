package com.vst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import com.vst.model.Db_Sequence;

@Service
public class Db_Service {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	 public int getSequenceNumber(String sequenceName) {
		 
		 Query query = new Query(Criteria.where("id").is(sequenceName));
		 
		 Update update= new Update().inc("seq", 1);
		 
		 Db_Sequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),Db_Sequence.class);
		 
		 return !Objects.isNull(counter) ? counter.getSeq() : 1;
	 }

}
