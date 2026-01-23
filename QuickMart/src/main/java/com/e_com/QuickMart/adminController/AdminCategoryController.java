package com.e_com.QuickMart.adminController;

import com.e_com.QuickMart.entity.sql.CategoryEntity;
import com.e_com.QuickMart.service.category.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/categories")
public class AdminCategoryController {

    private final CategoryService categoryService;

    public AdminCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * ADMIN: Create category
     */
    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createCategory(category);
    }

    /**
     * ADMIN: Update category
     */
    @PutMapping("/{id}")
    public CategoryEntity updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryEntity category) {
        return categoryService.updateCategory(id, category);
    }

    /**
     * ADMIN: Soft delete category
     */
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
