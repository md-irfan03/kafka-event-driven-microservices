package com.delivery.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.order.repository.IOrderRepository;

@Service
public class OrderService
{
	@Autowired
	IOrderRepository orderRepository ;
	
	public String getCustomerAddress(String orderId) {
		return orderRepository.findAddressByOrderId(orderId);
	}

}
