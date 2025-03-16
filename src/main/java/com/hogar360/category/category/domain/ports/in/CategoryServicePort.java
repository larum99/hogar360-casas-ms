package com.hogar360.category.category.domain.ports.in;

import com.hogar360.category.category.domain.model.CategoryModel;

public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
}
