package com.hogar360.category.category.infraestructure.repositories.mysql;

import com.hogar360.category.category.infraestructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
