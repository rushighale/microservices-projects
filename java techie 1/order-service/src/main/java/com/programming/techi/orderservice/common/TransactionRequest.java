package com.programming.techi.orderservice.common;

import com.programming.techi.orderservice.entity.Order;

import lombok.Data;

@Data
public class TransactionRequest {
	
	private Order order;
	private Payment payment;
	

}
