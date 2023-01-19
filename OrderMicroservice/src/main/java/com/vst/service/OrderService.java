package com.vst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vst.common.Payment;
import com.vst.common.PaymentService;
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
	Payment paymentResponce =	restTemplate.postForObject("http://PAYMENT-MICROSERVICE/payment/savePayment", payment, Payment.class);
	
	//System.out.println(paymentResponce);
		
		response =  paymentResponce.getPaymentStatus().equals("true") ?"payment proceed successfully and order place":
		"payment is not proceed order added to cart";
		
		 orderRepository.save(order);
		 return new TransactionResponce(order, paymentResponce.getAmount(),paymentResponce.getTransactionId(),response);
		 
	}

	public TransactionRequest getOrder(int id) {
		
		
		Order order=orderRepository.findById(id);
		
		String url = "http://PAYMENT-MICROSERVICE/payment/{orderId}";
		 Payment payment = new Payment();
		
		 payment= restTemplate.getForObject(url,Payment.class);

		System.out.println(order);
		//System.out.println(payment);
		 return new TransactionRequest(order,payment);
		
	}
}
