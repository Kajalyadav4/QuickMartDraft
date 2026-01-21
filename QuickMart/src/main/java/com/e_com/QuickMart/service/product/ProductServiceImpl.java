package com.e_com.QuickMart.service.product;

import com.e_com.QuickMart.entity.sql.ProductEntity;
import com.e_com.QuickMart.repository.sql.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity getProductDetails(Long productId) {

        return productRepository
                .findByIdAndIsActiveTrue(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + productId)
                );
    }
}
