package com.e_com.QuickMart.repository.sql;

import com.e_com.QuickMart.entity.sql.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Page<ProductEntity> findByCategoryIdAndIsActiveTrue(
            Long categoryId,
            Pageable pageable
    );
}
