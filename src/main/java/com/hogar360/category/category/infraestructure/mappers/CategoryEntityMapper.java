package com.hogar360.category.category.infraestructure.mappers;

import com.hogar360.category.category.domain.model.CategoryModel;
import com.hogar360.category.category.infraestructure.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    CategoryModel entityToModel(CategoryEntity categoryEntity);
}
