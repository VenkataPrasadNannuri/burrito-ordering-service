package com.generali.burritoorderingservice.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generali.burritoorderingservice.entity.Orders;
import com.generali.burritoorderingservice.repository.OrderRepository;

@RestController
public class OrderController {                                            
	
	@Autowired
	OrderRepository orderRepository;
	
	@PostMapping("/orders")
	public ResponseEntity<Object> createOrder(@Valid @RequestBody Orders order) {
		Orders dbOrders = orderRepository.save(order);
		return ResponseEntity.ok(dbOrders);

	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Orders> getOrderById(@PathVariable long orderId){
		Optional<Orders> orders = orderRepository.findById(orderId);
		
		if(!orders.isPresent()) {
			System.out.println("orderId is not found:"+orderId);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(orders.get());
		
	}
}
