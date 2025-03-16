package com.hogar360.category.category.infraestructure.endpoints.rest;

import com.hogar360.category.category.application.dto.request.SaveCategoryRequest;
import com.hogar360.category.category.application.dto.response.SaveCategoryResponse;
import com.hogar360.category.category.application.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(saveCategoryRequest));
    }
}
