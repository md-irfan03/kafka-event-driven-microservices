package com.order.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.order.response.OrderResponse;

@Service
public class KafkaProducer
{
	@Autowired
	KafkaTemplate<String, OrderEvent> kafkaTemplate;
	
	public void sendOrder(OrderEvent order) {
		System.out.println(
                "Sending order to Kafka: " + order.getOrderId()
        );
		
	    kafkaTemplate.send(
	            "order-created",
	            order.getOrderId().toString(),
	            order
	    ).whenComplete((result, exception) -> {

	    	if (exception == null) {

                System.out.println(
                        "SUCCESS - Order stored in Kafka: "
                        + order.getOrderId()
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
                        "FAILED - Order could not be stored: "
                        + order.getOrderId()
                );

                exception.printStackTrace();
            }
	    });
	}

}
