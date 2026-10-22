package com.payment.kafka.constant;

import java.util.Random;

public enum PaymentStatus
{
	SUCCESS,
	FAILED;
	
	public static PaymentStatus randomStatus() {
		Random random = new  Random();
		PaymentStatus[] statuses = PaymentStatus.values();
		
		return statuses[random.nextInt(statuses.length)];
	}

}
