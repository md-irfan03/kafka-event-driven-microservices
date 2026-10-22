package com.delivery.kafka.consumer;

import java.util.Random;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.delivery.kafka.constant.DeliveryStatus;
import com.delivery.kafka.model.DeliveryEvent;
import com.delivery.kafka.model.PaymentEvent;
import com.delivery.kafka.producer.DeliveryProducer;
import com.delivery.order.service.OrderService;

@Service
public class PaymentConsumer
{
	@Autowired
	OrderService orderService;
	
	@Autowired
	DeliveryProducer deliveryProducer;
	
	@KafkaListener(topics="payment-success", groupId="delivery-service-group")
	public void consumePayment(ConsumerRecord<String, PaymentEvent> record) {
		String key = record.key();
		PaymentEvent payment = record.value();

        System.out.println("========== MESSAGE RECEIVED BY DELIVERY CONSUMER ==========");

        System.out.println("Kafka Topic : " + record.topic());
        System.out.println("Partition   : " + record.partition());
        System.out.println("Offset      : " + record.offset());
        System.out.println("Key         : " + key);
        System.out.println("Payment-Event     : " + payment);

        System.out.println("======================================");
        
        
      //address -> we have to fetch from order-data
        String orderId = payment.getOrderId();
        String deliveryAddress = orderService.getCustomerAddress(orderId);
        
        // Simulate an unprocessable message - dlt
        if (deliveryAddress == null || deliveryAddress.isBlank()) {
        	System.out.println("TEST: Making this message unprocessable");

            throw new RuntimeException(
                    "Delivery cannot be created: delivery address is missing"
            );
        }

        // Only executed if address is valid
        DeliveryEvent deliveryEvent = new DeliveryEvent();
        String status = DeliveryStatus.randomStatus().name();
        deliveryEvent.setCustomerId(payment.getCustomerId());
        deliveryEvent.setOrderId(payment.getOrderId());
        deliveryEvent.setDeliveryAddress(deliveryAddress);
        deliveryEvent.setTrackingNumber("TRK" + generateTrackingNo() );
        deliveryEvent.setEventId("DEL-" + generateId());
        deliveryEvent.setEventType("DELIVERY-" + status);
        deliveryEvent.setDeliveryStatus(status);
        
        System.out.println(
                "Delivery created for Order: "
                + payment.getOrderId()
        );
        
        //sending to kafka as a producer
        deliveryProducer.produce(deliveryEvent);
        
        
        
	}
	
	private int generateTrackingNo() {
		Random random = new Random();
		return random.nextInt(10000, 99990);
	}

	private int generateId() {
		Random random = new Random();
		return random.nextInt(10000, 90000);
	}
}
