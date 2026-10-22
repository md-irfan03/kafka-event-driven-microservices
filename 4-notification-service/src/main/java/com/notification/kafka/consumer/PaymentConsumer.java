package com.notification.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.notification.kafka.model.PaymentEvent;

@Service
public class PaymentConsumer
{
	@KafkaListener(topics ="payment-failed", groupId="notification-service-group-2")
	public void consumePayment(ConsumerRecord<String, PaymentEvent> record) {
		String key = record.key();
		PaymentEvent payment = record.value();

        System.out.println("========== MESSAGE RECEIVED BY NOTIFICATION SERVICE ==========");

        System.out.println("Kafka Topic : " + record.topic());
        System.out.println("Partition   : " + record.partition());
        System.out.println("Offset      : " + record.offset());
        System.out.println("Key         : " + key);
        System.out.println("Payment-Event     : " + payment);

        System.out.println("======================================");
        
        System.out.println("===================PAYMENT FAILURE NOTIFICATION====================");
        System.out.println(
                "Notification SENT to Customer: "
                        + payment.getCustomerId()
                        + " >> \n Order Id: "
                        + payment.getOrderId()
                        + "\n Your payment of Rs."
                        + String.format("%.0f", payment.getAmount())
                        + " got failed."
                        );
	}
}
