package com.payment.kafka.consumer;

import java.util.Random;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.payment.kafka.constant.PaymentEventType;
import com.payment.kafka.constant.PaymentMethod;
import com.payment.kafka.constant.PaymentStatus;
import com.payment.kafka.model.OrderEvent;
import com.payment.kafka.model.PaymentEvent;
import com.payment.kafka.producer.PaymentProducer;

@Service
public class OrderConsumer
{
	@Autowired
	PaymentProducer paymentProducer;
	
	@KafkaListener(topics ="order-created", groupId="payment-service-group")
	public void consumeOrder(ConsumerRecord<String, OrderEvent> record) {
		String key = record.key();
		OrderEvent order = record.value();

        System.out.println("========== MESSAGE RECEIVED BY PAYMENT SERVICE ==========");

        System.out.println("Kafka Topic : " + record.topic());
        System.out.println("Partition   : " + record.partition());
        System.out.println("Offset      : " + record.offset());
        System.out.println("Key         : " + key);
        System.out.println("Order-Event     : " + order);

        System.out.println("======================================");
        
        //for duplicate processing, intentionally causing exception before committing offset ==> no offset committed --> processing again
//        String name = null;
//        if(name == null) {
//			throw new RuntimeException("TEST - Simulating consumer crash");
//        }
        
        // Payment processing
        System.out.println("========== PAYMENT PROCCESSING STARTED ==========");
        String paymentStatus = PaymentStatus.randomStatus().name();

        PaymentEvent paymentResult = new PaymentEvent();
        
        paymentResult.setEventId("PAY-" + generateEventId());
        paymentResult.setPaymentId("TXN-" + generatePaymentId());
        paymentResult.setAmount(order.getAmount());
    	paymentResult.setOrderId(order.getOrderId());
    	paymentResult.setCustomerId(order.getCustomerId());
    	paymentResult.setPaymentMethod(PaymentMethod.randomMethod().toString());
    	
    	System.out.println("========== PAYMENT PROCCESS COMPLETED ==========");
    	
        if (paymentStatus.equals("SUCCESS")) {
        	paymentResult.setEventType(PaymentEventType.PAYMENT_SUCCESS.name());
        	paymentResult.setPaymentStatus(paymentStatus);
   
        	//sending to kafka as a producer
        	paymentProducer.sendPaymentResult("payment-success", paymentResult);
        } else {
        	
        	paymentResult.setEventType(PaymentEventType.PAYMENT_FAILED.name());
        	paymentResult.setPaymentStatus(PaymentStatus.FAILED.name());
        	
        	//sending to kafka as a producer
        	paymentProducer.sendPaymentResult("payment-failed", paymentResult);
        }        

        
    }
	
	private int generateEventId()
	{
		Random random = new Random();
		return random.nextInt(10000, 99900);
	}
	
	private int generatePaymentId()
	{
		Random random = new Random();
		return random.nextInt(10000, 99900);
	}
}
