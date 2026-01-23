package com.e_com.QuickMart.adminController;


import com.e_com.QuickMart.entity.sql.CategoryEntity;
import com.e_com.QuickMart.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/categories")
@RequiredArgsConstructor
public class categoryController {

    private final CategoryService categoryService;

    // ✅ Create category
    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createCategory(category);
    }

    // ✅ Soft delete category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.softDeleteCategory(id);
        return "Category deleted successfully";
    }
}
