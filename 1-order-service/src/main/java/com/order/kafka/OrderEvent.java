package com.order.kafka;

public class OrderEvent
{
	private String eventId;
	private String eventType;
	private String orderId;
	private int customerId;
	private double amount;
	private String deliveryAddress;

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

	public String getDeliveryAddress()
	{
		return deliveryAddress;
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

	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

}