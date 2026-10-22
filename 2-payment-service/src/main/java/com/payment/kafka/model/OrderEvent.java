package com.payment.kafka.model;

public class OrderEvent
{
	private String eventId;
	private String eventType;
	private String orderId;
	private int customerId;
	private int amount;
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

	public int getAmount()
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

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString()
	{
		return "OrderEvent : [eventId=" + eventId + ", eventType=" + eventType + ", orderId=" + orderId + ", customerId="
				+ customerId + ", amount=" + amount + ", deliveryAddress=" + deliveryAddress + "]";
	}
	
	

}