package com.e_com.QuickMart.service.product;

import com.e_com.QuickMart.entity.sql.ProductEntity;
<<<<<<< Updated upstream
import com.e_com.QuickMart.repository.sql.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

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
=======

public interface ProductService {

    ProductEntity getProductDetails(Long productId);
>>>>>>> Stashed changes
}
