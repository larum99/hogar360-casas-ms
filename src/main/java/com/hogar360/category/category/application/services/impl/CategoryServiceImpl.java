package com.hogar360.category.category.application.services.impl;

import com.hogar360.category.category.application.dto.request.SaveCategoryRequest;
import com.hogar360.category.category.application.dto.response.SaveCategoryResponse;
import com.hogar360.category.category.application.mappers.CategoryDtoMapper;
import com.hogar360.category.category.application.services.CategoryService;
import com.hogar360.category.category.domain.ports.in.CategoryServicePort;
import com.hogar360.category.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save(categoryDtoMapper.requestToModel(request));
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }
}
