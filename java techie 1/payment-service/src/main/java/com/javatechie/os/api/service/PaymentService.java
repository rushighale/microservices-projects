package com.javatechie.os.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.os.api.entity.Payment;
import com.javatechie.os.api.repository.PayementRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PayementRepository repository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);
	}
	
	
	public String paymentProcessing() {
		
		// api should be 3rd party payment gateway (paypal,paytem)
	 return	new Random().nextBoolean()?"success":"false";
	}


	public Payment findPaymentHistoryByOrderId(int orderId) {
		return repository.findByOrderId(orderId);
	
	}
	
	
	

}
