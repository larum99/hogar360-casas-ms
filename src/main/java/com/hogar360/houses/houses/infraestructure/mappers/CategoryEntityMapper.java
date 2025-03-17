package com.hogar360.houses.houses.infraestructure.mappers;

import com.hogar360.houses.houses.domain.model.CategoryModel;
import com.hogar360.houses.houses.infraestructure.entities.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    CategoryModel entityToModel(CategoryEntity categoryEntity);
    List<CategoryModel> entityListToModelList(List<CategoryEntity> categories);
}
