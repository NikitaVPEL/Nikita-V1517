package com.vst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
