package com.order.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.constant.OrderStatus;
import com.order.entity.OrderEntity;
import com.order.kafka.KafkaProducer;
import com.order.kafka.OrderEvent;
import com.order.repository.IOrderRepository;
import com.order.request.OrderRequest;
import com.order.response.OrderResponse;

import jakarta.transaction.Transactional;
import tools.jackson.databind.ObjectMapper;

@Service
public class OrderService
{
	@Autowired
	IOrderRepository orderRepository;

	@Autowired
	KafkaProducer producer;

	Random randm = new Random();

	@Transactional
	public OrderResponse acceptOrder(OrderRequest orderRequest) {
		OrderEntity orderEntity = new OrderEntity();
		
		orderEntity.setCustomerId(orderRequest.getCustomerId());
		orderEntity.setProductName(orderRequest.getProductName());
		orderEntity.setQuantity(orderRequest.getQuantity());
		orderEntity.setDeliveryAddress(orderRequest.getDeliveryAddress());
		orderEntity.setProductId(generateProductId());
		orderEntity.setOrderId("ORD-" + generateOrderId());
		orderEntity.setTotalAmount(calculateAmount());
		orderEntity.setStatus(OrderStatus.CREATED.name());
		
		OrderEntity savedOrder = orderRepository.save(orderEntity);
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setCustomerId(savedOrder.getCustomerId());
		orderResponse.setOrderId(savedOrder.getOrderId());
		orderResponse.setProductId(savedOrder.getProductId());
		orderResponse.setProductName(savedOrder.getProductName());
		orderResponse.setStatus(savedOrder.getStatus());
		orderResponse.setTotalAmount(savedOrder.getTotalAmount());
		orderResponse.setOrderDate(savedOrder.getOrderDate());
		orderResponse.setQuantity(savedOrder.getQuantity());
		orderResponse.setDeliveryAddress(savedOrder.getDeliveryAddress());
		
		//producer will send message 
		sendOrderToKafka(orderResponse);
	
		return orderResponse;
	}

	private int generateProductId()
	{
		return randm.nextInt(1, 5000);
	}

	private int calculateAmount()
	{
		return randm.nextInt(1000, 5000);
	}

	private int generateOrderId()
	{
		return randm.nextInt(10000, 99990);
	}

//	private String convertToJson(OrderResponse orderResponse)
//	{
//		ObjectMapper objectMapper = new ObjectMapper();
//		String data = objectMapper.writeValueAsString(orderResponse);
//		return data;
//	}
	
	private void sendOrderToKafka(OrderResponse order) {
		OrderEvent event = new OrderEvent();
		event.setCustomerId(order.getCustomerId());
		event.setAmount(order.getTotalAmount());
		event.setDeliveryAddress(order.getDeliveryAddress());
		event.setEventId("EVT-" + generateEventId());
		event.setEventType("ORDER-CREATED");
		event.setOrderId(order.getOrderId());
		
		producer.sendOrder(event);
		
		
	}

	private int generateEventId()
	{
		// TODO Auto-generated method stub
		return randm.nextInt(10000, 99900);
	}

}
