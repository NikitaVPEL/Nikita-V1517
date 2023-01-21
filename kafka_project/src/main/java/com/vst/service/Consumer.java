package com.vst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vst.model.User;

@Service
public class Consumer {

//
//	@KafkaListener(topics = "kafkaTopic", groupId = "1stPartition")
//	public void consumeTopic(String receivemessage) {
//		System.out.println("the received massage is " + receivemessage);
//
//	}
    
	@KafkaListener(topics = "mongoindex", groupId = "1st")
	public void Consumer(@Payload List<User> user) {
		System.out.println("data is" + user );
		//return user;
	}
}
