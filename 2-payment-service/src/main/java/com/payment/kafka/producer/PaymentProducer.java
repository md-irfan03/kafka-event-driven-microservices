package com.payment.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.payment.kafka.model.PaymentEvent;

@Service
public class PaymentProducer
{
	@Autowired
	KafkaTemplate<String, PaymentEvent> producer;
	
	public void sendPaymentResult(String topic, PaymentEvent paymentEvent)
	{
		System.out.println(
                "Sending payment to Kafka: " + paymentEvent.getOrderId()
        );
		producer.send(topic, paymentEvent.getOrderId(), paymentEvent)
		.whenComplete((result, exception) -> {
			if (exception == null) {

                System.out.println(
                		"Payment-event sent to Kafka : "
                        + paymentEvent.getOrderId()
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
                		"Failed to send Payment-event"
                        + paymentEvent.getOrderId()
                );

                exception.printStackTrace();
            }
		});
		
	}

}
