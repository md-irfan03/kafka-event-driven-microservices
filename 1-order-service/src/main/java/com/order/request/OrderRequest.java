package com.order.request;

public class OrderRequest
{
	private int customerId;
	private String productName;
	private int quantity;
	private String deliveryAddress;

	public int getCustomerId()
	{
		return customerId;
	}

	public String getProductName()
	{
		return productName;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public String getDeliveryAddress()
	{
		return deliveryAddress;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

}
