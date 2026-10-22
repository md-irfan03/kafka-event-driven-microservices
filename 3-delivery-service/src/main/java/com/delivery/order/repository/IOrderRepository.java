package com.delivery.order.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.delivery.order.entity.OrderEntity;

public interface IOrderRepository extends CrudRepository<OrderEntity, Integer>
{
	@Query("select o.deliveryAddress from OrderEntity o where o.orderId= :id")	//jpql
	public String findAddressByOrderId(@Param("id") String orderId);

}
