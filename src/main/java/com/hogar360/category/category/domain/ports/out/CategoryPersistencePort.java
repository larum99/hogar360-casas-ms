package com.hogar360.category.category.domain.ports.out;

import com.hogar360.category.category.domain.model.CategoryModel;

public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
}
