package com.notification.kafka.model;

public class DeliveryEvent
{
	private String eventId;
	private String eventType;
	private String orderId;
	private int customerId;
	private String trackingNumber;
	private String deliveryAddress;
	private String deliveryStatus;

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

	public String getTrackingNumber()
	{
		return trackingNumber;
	}

	public String getDeliveryAddress()
	{
		return deliveryAddress;
	}

	public String getDeliveryStatus()
	{
		return deliveryStatus;
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

	public void setTrackingNumber(String trackingNumber)
	{
		this.trackingNumber = trackingNumber;
	}

	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

	public void setDeliveryStatus(String deliveryStatus)
	{
		this.deliveryStatus = deliveryStatus;
	}

	@Override
	public String toString()
	{
		return "DeliveryEvent [eventId=" + eventId + ", eventType=" + eventType + ", orderId=" + orderId
				+ ", customerId=" + customerId + ", trackingNumber=" + trackingNumber + ", deliveryAddress="
				+ deliveryAddress + ", deliveryStatus=" + deliveryStatus + "]";
	}

	
	
}
