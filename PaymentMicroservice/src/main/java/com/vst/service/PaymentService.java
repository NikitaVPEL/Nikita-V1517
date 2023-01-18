package com.vst.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.model.Payment;
import com.vst.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment savePayment(Payment payment) {

		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	public String paymentProcessing() {

		return new Random().nextBoolean() ? "true" : "false";
	}

	public Payment findPaymentHistoryByOrderId(int orderId) {
		
		return paymentRepository.findByOrderId(orderId);
	}
}
