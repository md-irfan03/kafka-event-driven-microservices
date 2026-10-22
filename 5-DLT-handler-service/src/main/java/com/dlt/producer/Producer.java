package com.dlt.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dlt.kafka.model.PaymentEvent;

@Service
public class Producer
{
	@Autowired
	KafkaTemplate<String, PaymentEvent> kafkaTemplate;

	public void sendPayment(PaymentEvent payment)
	{
		kafkaTemplate.send("payment-success", payment.getOrderId(), payment)
		.whenComplete((result, exception) -> {

			if (exception == null) {

                System.out.println(
                		"Payment-event sent to Kafka : "
                        + payment.getOrderId()
                );

                System.out.println(
                        "Topic     : "
                        + result.getRecordMetadata().topic()
                );

                System.out.println(
                        "Partition : "
                        + result.getRecordMetadata().partition()
                );

                System.out.println(
                        "Offset    : "
                        + result.getRecordMetadata().offset()
                );

            } else {

                System.out.println(
                		"Failed to send Delivery-event"
                        + payment.getOrderId()
                );

                exception.printStackTrace();
            }
		});
		
		
	}
	
	

}
