package com.vst.service;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vst.common.Payment;
import com.vst.common.TransactionRequest;
import com.vst.common.TransactionResponce;
import com.vst.model.Order;
import com.vst.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public TransactionResponce saveOrder(TransactionRequest request) {
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		//rest call
	Payment paymentResponce =	restTemplate.postForObject("http://localhost:9091/payment/savePayment", payment, Payment.class);
	
	//System.out.println(paymentResponce);
		
		response =  paymentResponce.getPaymentStatus().equals("true") ?"payment proceed successfully and order place":
		"payment is not proceed order added to cart";
		
		 orderRepository.save(order);
		 return new TransactionResponce(order, paymentResponce.getAmount(),paymentResponce.getTransactionId(),response);
		 
	}

}
