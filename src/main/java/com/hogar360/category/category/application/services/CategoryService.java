package com.hogar360.category.category.application.services;

import com.hogar360.category.category.application.dto.request.SaveCategoryRequest;
import com.hogar360.category.category.application.dto.response.SaveCategoryResponse;

public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);
}
