package com.delivery.kafka.constant;

import java.util.Random;

public enum DeliveryStatus {

	CREATED, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED;

	public static DeliveryStatus randomStatus()
	{
		DeliveryStatus[] statuses = DeliveryStatus.values();
		return statuses[new Random().nextInt(statuses.length)];
	}

}
