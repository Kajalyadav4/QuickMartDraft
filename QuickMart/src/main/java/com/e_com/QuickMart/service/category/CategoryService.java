package com.e_com.QuickMart.service.category;

import com.e_com.QuickMart.entity.sql.CategoryEntity;
import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getAllActiveCategories();

}
