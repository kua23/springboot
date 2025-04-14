package com.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
