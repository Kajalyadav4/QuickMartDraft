package com.e_com.QuickMart.service.category;

import com.e_com.QuickMart.entity.sql.CategoryEntity;
import com.e_com.QuickMart.repository.sql.CategoryRepository;
import com.e_com.QuickMart.service.category.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> getAllActiveCategories() {
        return categoryRepository.findByIsActiveTrue();
    }
}
