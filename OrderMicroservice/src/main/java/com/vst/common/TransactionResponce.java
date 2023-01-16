package com.vst.common;

import com.vst.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponce {
	
	private Order order;
	private double amount;
	private String transactionId;
	private String message;

}
