package com.vst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, Integer>{

	Payment findByOrderId(int orderId);

}
