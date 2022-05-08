package com.programming.techi.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ORDER_TB")
@Data
public class Order {
	
	@Id
	
	private  int id;
	private String name;
	private int qty;
	private double price;
	

}
