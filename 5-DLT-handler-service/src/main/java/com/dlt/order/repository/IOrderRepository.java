package com.dlt.order.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dlt.order.entity.OrderEntity;

public interface IOrderRepository extends CrudRepository<OrderEntity, Integer>
{
	@Modifying
	@Query("update OrderEntity o set o.deliveryAddress = :newAddress where o.orderId = :id")	//JPQL --> works on class entity
	public int updateAddress(@Param("id") String orderId, @Param("newAddress") String newAddrs);
	
	public OrderEntity readByOrderId(String orderId);
}
