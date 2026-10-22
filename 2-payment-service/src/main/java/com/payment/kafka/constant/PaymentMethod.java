package com.payment.kafka.constant;

import java.util.Random;

public enum PaymentMethod {
    UPI,
    CREDIT_CARD,
    DEBIT_CARD;
    
    public static PaymentMethod randomMethod() {
		Random random = new  Random();
		PaymentMethod[] statuses = PaymentMethod.values();
		
		return statuses[random.nextInt(statuses.length)];
	}
}