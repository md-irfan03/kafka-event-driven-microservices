package com.order.response;

import java.time.LocalDate;

public class OrderResponse
{
	private String orderId;
	private int customerId;
	private int productId;
	private String productName;
	private int quantity;
	private LocalDate orderDate;
	private double totalAmount;
	private String status;
	private String deliveryAddress;
	public String getOrderId()
	{
		return orderId;
	}
	public int getCustomerId()
	{
		return customerId;
	}
	public int getProductId()
	{
		return productId;
	}
	public String getProductName()
	{
		return productName;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public LocalDate getOrderDate()
	{
		return orderDate;
	}
	public double getTotalAmount()
	{
		return totalAmount;
	}
	public String getStatus()
	{
		return status;
	}
	public String getDeliveryAddress()
	{
		return deliveryAddress;
	}
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public void setOrderDate(LocalDate orderDate)
	{
		this.orderDate = orderDate;
	}
	public void setTotalAmount(double totalAmount)
	{
		this.totalAmount = totalAmount;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}
	
	
}
