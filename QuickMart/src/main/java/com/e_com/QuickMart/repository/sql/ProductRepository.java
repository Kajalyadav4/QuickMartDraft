package com.e_com.QuickMart.repository.sql;

import com.e_com.QuickMart.entity.sql.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

<<<<<<< Updated upstream
    Page<ProductEntity> findByCategoryIdAndIsActiveTrue(
            Long categoryId,
            Pageable pageable
    );
=======
    // User: fetch active products by category (paginated)
    Page<ProductEntity> findByCategoryIdAndIsActiveTrue(Long categoryId, Pageable pageable);

    // User/Admin: count active products in category
    long countByCategoryIdAndIsActiveTrue(Long categoryId);

    // Admin: fetch product by id (active)
    Optional<ProductEntity> findByIdAndIsActiveTrue(Long id);
>>>>>>> Stashed changes
}
