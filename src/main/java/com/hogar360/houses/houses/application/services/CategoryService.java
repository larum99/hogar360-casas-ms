package com.hogar360.houses.houses.application.services;

import com.hogar360.houses.houses.application.dto.request.SaveCategoryRequest;
import com.hogar360.houses.houses.application.dto.response.CategoryResponse;
import com.hogar360.houses.houses.application.dto.response.SaveCategoryResponse;

import java.util.List;

public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);
    List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
