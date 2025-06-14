package com.wbs.springboot_nelio_alves.repository;

import com.wbs.springboot_nelio_alves.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
