package com.delivery.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.delivery.kafka.model.DeliveryEvent;

@Service
public class DeliveryProducer
{
	@Autowired
	KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

	public void produce(DeliveryEvent deliveryEvent)
	{
		
		System.out.println(
                "Sending delivery to Kafka: " + deliveryEvent.getOrderId()
        );
		kafkaTemplate.send("delivery", deliveryEvent.getOrderId().toString(), deliveryEvent)
				.whenComplete((result, exception) -> {

					if (exception == null) {

		                System.out.println(
		                		"Delivery-event sent to Kafka : "
		                        + deliveryEvent.getOrderId()
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
		                        + deliveryEvent.getOrderId()
		                );

		                exception.printStackTrace();
		            }
				});
	}

}
