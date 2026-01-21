package com.e_com.QuickMart.userController;

import com.e_com.QuickMart.entity.sql.ProductEntity;
import com.e_com.QuickMart.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductEntity> getProducts(
            @RequestParam Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return productService.getProductsByCategory(categoryId, page, size);
    }
}
