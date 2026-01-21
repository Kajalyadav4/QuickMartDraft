package com.e_com.QuickMart.userController;

import com.e_com.QuickMart.entity.sql.CategoryEntity;
import com.e_com.QuickMart.service.category.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * Fetch all active categories
     */
    @GetMapping
    public List<CategoryEntity> getAllActiveCategories() {
        return categoryService.getAllActiveCategories();
    }
    @GetMapping("/test")
    public CategoryEntity test() {
        return categoryService.getAllActiveCategories().getFirst();
    }

}
