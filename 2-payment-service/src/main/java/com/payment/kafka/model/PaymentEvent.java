package com.payment.kafka.model;

public class PaymentEvent
{

	private String eventId;
	private String eventType;

	private String orderId;
	private int customerId;

	private double amount;

	private String paymentId;
	private String paymentMethod;
	private String paymentStatus;

	public String getEventId()
	{
		return eventId;
	}

	public String getEventType()
	{
		return eventType;
	}

	public String getOrderId()
	{
		return orderId;
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public double getAmount()
	{
		return amount;
	}

	public String getPaymentId()
	{
		return paymentId;
	}

	public String getPaymentMethod()
	{
		return paymentMethod;
	}

	public String getPaymentStatus()
	{
		return paymentStatus;
	}

	public void setEventId(String eventId)
	{
		this.eventId = eventId;
	}

	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public void setPaymentId(String paymentId)
	{
		this.paymentId = paymentId;
	}

	public void setPaymentMethod(String paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public void setPaymentStatus(String paymentStatus)
	{
		this.paymentStatus = paymentStatus;
	}

}
