package com.programming.techi.orderservice.common;

import com.programming.techi.orderservice.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionResponse {
	
	private Order order;
	private double amount;
	private String transactionId;
	private String message;

}
