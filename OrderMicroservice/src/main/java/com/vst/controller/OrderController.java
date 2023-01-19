package com.vst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.common.Payment;
import com.vst.common.TransactionRequest;
import com.vst.common.TransactionResponce;
import com.vst.model.Order;
import com.vst.service.Db_Service;
import com.vst.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	Db_Service db_Service;
	

	
	@PostMapping("/postOrder")
	public TransactionResponce postOrder(@RequestBody TransactionRequest request) {
	
				return orderService.saveOrder(request);
	
	}
	
	@GetMapping("/{id}")
	public TransactionRequest getOrder(@PathVariable int id) {
		
		return orderService.getOrder(id);
		
	}

}
