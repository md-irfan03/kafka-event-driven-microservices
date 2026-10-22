package com.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.order.entity.OrderEntity;

public interface IOrderRepository extends CrudRepository<OrderEntity, Integer>
{
//	/**
//	 * it returns a particular order details
//	 * @param id
//	 * @return {@link #OrderEntity}
//	 */
//	public OrderEntity getByOrderId(String id);
//	
//	
//	/**
//	 * it returns a list of Orders of a particular customerId
//	 * @param id
//	 * @return {@link #List}<{@link #OrderEntity}>	
//	 */
//	public List<OrderEntity> readByCustomerId(int id);
	
	
}
