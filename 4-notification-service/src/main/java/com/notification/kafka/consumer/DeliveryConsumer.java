package com.notification.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.notification.kafka.model.DeliveryEvent;

@Service
public class DeliveryConsumer
{
	@KafkaListener(topics="delivery", groupId="Notification-service-group-1")
	public void consumeDelivery(ConsumerRecord<String, DeliveryEvent> record) {
		String key = record.key();
		DeliveryEvent delivery = record.value();

        System.out.println("========== MESSAGE RECEIVED BY NOTIFICATION SERVICE ==========");

        System.out.println("Kafka Topic : " + record.topic());
        System.out.println("Partition   : " + record.partition());
        System.out.println("Offset      : " + record.offset());
        System.out.println("Key         : " + key);
        System.out.println("Delivery-Event     : " + delivery);

        System.out.println("======================================");
        
        
        System.out.println("===================NOTIFICATION====================");
        System.out.println(
                "Delivery Notification SENT to Customer: "
                        + delivery.getCustomerId()
                        + " >> \n Order Id: "
                        + delivery.getOrderId()
                        + "\n Tracking No : "
                        + delivery.getTrackingNumber()
                        + "\n Delivery Address :"
                        + delivery.getDeliveryAddress()
                        + "\n Delivery Status : "
                        + delivery.getDeliveryStatus()
        );
	}
	
}
