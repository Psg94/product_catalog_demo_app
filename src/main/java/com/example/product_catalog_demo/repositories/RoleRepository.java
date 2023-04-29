package com.example.product_catalog_demo.repositories;

import com.example.product_catalog_demo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
