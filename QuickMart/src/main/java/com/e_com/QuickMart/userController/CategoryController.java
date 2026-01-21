package com.e_com.QuickMart.userController;

import com.e_com.QuickMart.entity.sql.CategoryEntity;
import com.e_com.QuickMart.service.category.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * USER API
     * Get all active categories
     */
    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllActiveCategories();
    }
}
