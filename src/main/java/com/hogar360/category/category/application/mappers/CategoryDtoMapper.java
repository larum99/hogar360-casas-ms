package com.hogar360.category.category.application.mappers;

import com.hogar360.category.category.application.dto.request.SaveCategoryRequest;
import com.hogar360.category.category.application.dto.response.CategoryResponse;
import com.hogar360.category.category.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
    CategoryResponse modelToResponse(CategoryModel categoryModel);
}
