package com.hogar360.category.category.domain.ports.in;

import com.hogar360.category.category.domain.model.CategoryModel;

import java.util.List;

public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
    List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
