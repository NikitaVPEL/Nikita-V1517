package com.vst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.model.Payment;
import com.vst.service.Db_Service;
import com.vst.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private Db_Service db_Service;
	
	@PostMapping("/savePayment")
	public Payment postPayment(@RequestBody Payment payment) {
		payment.setPaymentId(db_Service.getSequenceGenerator(payment.SEQUENCE_NAME));
		return paymentService.savePayment(payment);
	}
	
	@GetMapping
	public Payment findPaymentHistoryByOrderId(@RequestParam("orderId") int orderId) {
		
		return paymentService.findPaymentHistoryByOrderId(orderId);
	}

}
