package com.e_com.QuickMart.service.product;

import com.e_com.QuickMart.entity.sql.ProductEntity;
import com.e_com.QuickMart.repository.sql.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<ProductEntity> getProductsByCategory(
            Long categoryId,
            int page,
            int size
    ) {
        return productRepository.findByCategoryIdAndIsActiveTrue(
                categoryId,
                PageRequest.of(page, size)
        );
    }

    @Override
    public ProductEntity getProductDetails(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
