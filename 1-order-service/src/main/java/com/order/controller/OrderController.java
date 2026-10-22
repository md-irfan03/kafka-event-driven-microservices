package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.request.OrderRequest;
import com.order.response.OrderResponse;
import com.order.service.OrderService;

@RestController
@RequestMapping("/ecommerce")
public class OrderController
{
	@Autowired
	OrderService orderService;

	@PostMapping("/create-order")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
		System.out.println("OrderController.createOrder()");
		
		OrderResponse orderResponse = orderService.acceptOrder(orderRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
		
	}
	
}
