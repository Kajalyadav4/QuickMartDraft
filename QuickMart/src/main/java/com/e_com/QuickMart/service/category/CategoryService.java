package com.e_com.QuickMart.service.category;

import com.e_com.QuickMart.entity.sql.CategoryEntity;
import java.util.List;

public interface CategoryService {

    // USER
    List<CategoryEntity> getAllActiveCategories();

    // ADMIN
    CategoryEntity createCategory(CategoryEntity category);
    CategoryEntity updateCategory(Long id, CategoryEntity category);
    void deleteCategory(Long id);
}
