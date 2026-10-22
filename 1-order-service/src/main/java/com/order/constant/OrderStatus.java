package com.order.constant;

import java.util.Random;

public enum OrderStatus
{
	CREATED,
	CONFIRMED,
//	PROCESSING,
//	PACKED,
//	SHIPPED,
//	OUT_FOR_DELIVERY,
//	DELIVERED,
	CANCELLED;
//	RETURN_REQUESTED,
//	RETURNED,
//	REFUNDED
	
	public static OrderStatus getStatus() {
		OrderStatus[] statuses = OrderStatus.values();
		
		Random randm = new Random();
		int randomIndex = randm.nextInt(statuses.length);
		return statuses[randomIndex];
	}
}
