package com.javatechie.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.os.api.entity.Payment;

public interface PayementRepository extends JpaRepository<Payment, Integer>{

	Payment findByOrderId(int orderId);

}

