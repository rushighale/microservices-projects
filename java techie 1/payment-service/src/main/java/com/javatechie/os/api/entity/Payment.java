package com.javatechie.os.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PAYMENT_TB")
@Data
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	
	//
	private int orderId;
	private int amount;
	
	
}
