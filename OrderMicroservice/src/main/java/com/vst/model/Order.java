package com.vst.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection  = "Order")
public class Order {
	
	@Transient
	public static final String  SEQUENCE_NAME = "order";

	
	@Id
	private int id;
	
	private String name;
	private int qty;
	private double price;

}
