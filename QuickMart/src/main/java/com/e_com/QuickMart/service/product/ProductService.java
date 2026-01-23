package com.e_com.QuickMart.service.product;

import com.e_com.QuickMart.entity.sql.ProductEntity;
import org.springframework.data.domain.Page;

public interface ProductService {

    Page<ProductEntity> getProductsByCategory(Long categoryId, int page, int size);

    ProductEntity getProductDetails(Long productId);
}
