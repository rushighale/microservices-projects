package com.programming.techi.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;
import com.programming.techi.orderservice.common.Payment;
import com.programming.techi.orderservice.common.TransactionRequest;
import com.programming.techi.orderservice.common.TransactionResponse;
import com.programming.techi.orderservice.entity.Order;
import com.programming.techi.orderservice.repository.OrderRepository;

@Service

public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	@Autowired
	private RestTemplate template;
	
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response="";
		
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		
		// rest call
		// set payment with orderId and amount , and call rest API POST
	Payment paymentResponse=	template.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
		
	response =paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"thre is failure in payment api, order added to cart";
	
		
	    repository.save(order);
	    
	    return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	    
	    
	    
	    
	}
	

}
