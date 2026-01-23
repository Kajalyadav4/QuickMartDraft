package com.e_com.QuickMart.repository.sql;

import com.e_com.QuickMart.entity.sql.CategoryEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    // User: fetch only active categories
    List<CategoryEntity> findByIsActiveTrue();

    // User/Admin: fetch category by id (only active)
    Optional<CategoryEntity> findByIdAndIsActiveTrue(Long id);

    // Admin: check if category exists by name
    boolean existsByName(String name);

    // Admin: soft delete
    @Modifying
    @Transactional
    @Query("UPDATE CategoryEntity c SET c.isActive = false WHERE c.id = :id")
    void softDeleteById(Long id);
}
