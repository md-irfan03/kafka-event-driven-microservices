package com.dlt.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.order.entity.OrderEntity;
import com.dlt.order.repository.IOrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService
{
	@Autowired
	IOrderRepository orderRepository ;
	
	@Transactional
	public int updateCustomerAddress(String orderId, String address) {
		return orderRepository.updateAddress(orderId, address);
	}
	
	public OrderEntity getOrderDetail(String orderId) {
		return orderRepository.readByOrderId(orderId);
	}

}
