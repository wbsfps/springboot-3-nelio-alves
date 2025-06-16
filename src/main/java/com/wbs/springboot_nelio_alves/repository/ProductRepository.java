package com.wbs.springboot_nelio_alves.repository;

import com.wbs.springboot_nelio_alves.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
