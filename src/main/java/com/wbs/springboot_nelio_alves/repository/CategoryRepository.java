package com.wbs.springboot_nelio_alves.repository;

import com.wbs.springboot_nelio_alves.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
