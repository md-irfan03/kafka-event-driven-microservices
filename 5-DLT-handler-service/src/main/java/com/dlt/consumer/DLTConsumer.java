package com.dlt.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dlt.kafka.model.PaymentEvent;
import com.dlt.order.entity.OrderEntity;
import com.dlt.order.service.OrderService;
import com.dlt.producer.Producer;

@Service
public class DLTConsumer
{
	@Autowired
	OrderService orderService;
	
	@Autowired 
	Producer producer;

	@KafkaListener(topics = "payment-success.DLT", groupId = "payment-success-dlt-group")
	public void consumeDlt(ConsumerRecord<String, PaymentEvent> record)
	{
		PaymentEvent payment = record.value();

		System.out.println("========== UNPROCESSABLE MESSAGE RECEIVED FROM DLT ==========");

		System.out.println("Topic     : " + record.topic());
		System.out.println("Partition : " + record.partition());
		System.out.println("Offset    : " + record.offset());
		System.out.println("Key       : " + record.key());
		System.out.println("Payment   : " + payment);

		System.out.println("=================================");

		System.out.println("PROCESSING DLT MESSAGE : " + payment.getOrderId());

		String address = "BTM, 1st Stage, Bengaluru, Karnataka, India";
		String orderId = payment.getOrderId();

		int rowAffected = orderService.updateCustomerAddress(orderId, address);

		if (rowAffected > 0)
		{
//			OrderEntity orderEntity = orderService.getOrderDetail(orderId);
			System.out.println("DLT issue resolved......  ");
			
			producer.sendPayment(payment);
		}
		
		

	}
}
