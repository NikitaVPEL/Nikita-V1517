package com.vst.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(name = "paymentService")
public interface PaymentService {
	
@RequestMapping("http://PAYMENT-MICROSERVICE/payment/{orderId}")
Payment getById(@PathVariable int orderId);
	

}
