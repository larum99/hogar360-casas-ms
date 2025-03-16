package com.hogar360.category.commons.configurations.beans;

import com.hogar360.category.category.domain.ports.in.CategoryServicePort;
import com.hogar360.category.category.domain.ports.out.CategoryPersistencePort;
import com.hogar360.category.category.domain.usecases.CategoryUseCase;
import com.hogar360.category.category.infraestructure.adapters.persistence.CategoryPersistenceAdapter;
import com.hogar360.category.category.infraestructure.mappers.CategoryEntityMapper;
import com.hogar360.category.category.infraestructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }
}
