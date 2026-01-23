package com.e_com.QuickMart.service.category;

import com.e_com.QuickMart.entity.sql.CategoryEntity;
import com.e_com.QuickMart.repository.sql.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * USER
     */
    @Override
    public java.util.List<CategoryEntity> getAllActiveCategories() {
        return categoryRepository.findByIsActiveTrue();
    }

    /**
     * ADMIN: Create category
     */
    @Override
    public CategoryEntity createCategory(CategoryEntity category) {

        if (categoryRepository.existsByName(category.getName())) {
            throw new RuntimeException("Category already exists with name: " + category.getName());
        }

        category.setId(null); // ensure new insert
        category.setIsActive(true);

        return categoryRepository.save(category);
    }

    /**
     * ADMIN: Update category
     */
    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity updatedCategory) {

        CategoryEntity existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());
        existingCategory.setImageUrl(updatedCategory.getImageUrl());
        existingCategory.setIsActive(updatedCategory.getIsActive());

        return categoryRepository.save(existingCategory);
    }

    /**
     * ADMIN: Soft delete category
     */
    @Override
    public void deleteCategory(Long id) {

        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }

        categoryRepository.softDeleteById(id);
    }
}
