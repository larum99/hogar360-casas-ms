package com.hogar360.category.category.infraestructure.adapters.persistence;

import com.hogar360.category.category.domain.model.CategoryModel;
import com.hogar360.category.category.domain.ports.out.CategoryPersistencePort;
import com.hogar360.category.category.infraestructure.mappers.CategoryEntityMapper;
import com.hogar360.category.category.infraestructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }
}
