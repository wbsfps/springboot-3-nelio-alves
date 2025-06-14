package com.wbs.springboot_nelio_alves.repository;

import com.wbs.springboot_nelio_alves.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
