package com.wbs.springboot_nelio_alves.repository;

import com.wbs.springboot_nelio_alves.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
