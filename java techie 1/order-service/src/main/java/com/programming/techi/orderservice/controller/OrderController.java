package com.programming.techi.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techi.orderservice.common.TransactionRequest;
import com.programming.techi.orderservice.common.TransactionResponse;
import com.programming.techi.orderservice.service.OrderService;

@RestController

@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
	
		return service.saveOrder(request);
		
		// do rest call to payment and pass the order id,....here one to one or many to one mapping is not possible in microservices
		
		
	}

}
