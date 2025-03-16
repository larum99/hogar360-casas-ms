package com.hogar360.category.category.domain.usecases;

import com.hogar360.category.category.domain.exceptions.CategoryAlreadyExistsException;
import com.hogar360.category.category.domain.model.CategoryModel;
import com.hogar360.category.category.domain.ports.in.CategoryServicePort;
import com.hogar360.category.category.domain.ports.out.CategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());
        if (category != null) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.save(categoryModel);
    }
}
