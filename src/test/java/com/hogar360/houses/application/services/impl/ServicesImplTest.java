package com.hogar360.houses.application.services.impl;

import com.hogar360.houses.houses.application.dto.request.SaveCategoryRequest;
import com.hogar360.houses.houses.application.dto.response.CategoryResponse;
import com.hogar360.houses.houses.application.dto.response.SaveCategoryResponse;
import com.hogar360.houses.houses.application.mappers.CategoryDtoMapper;
import com.hogar360.houses.houses.application.services.impl.CategoryServiceImpl;
import com.hogar360.houses.houses.domain.model.CategoryModel;
import com.hogar360.houses.houses.domain.ports.in.CategoryServicePort;
import com.hogar360.houses.commons.configurations.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServicesImplTest {

    @Mock
    private CategoryServicePort categoryServicePort;

    @Mock
    private CategoryDtoMapper categoryDtoMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private SaveCategoryRequest request;
    private CategoryModel categoryModel;
    private SaveCategoryResponse saveResponse;

    @BeforeEach
    void setUp() {
        request = new SaveCategoryRequest("House", "A category for houses");
        categoryModel = new CategoryModel(1L, "House", "A category for houses");
        saveResponse = new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Test
    void testSaveCategory_Success() {
        when(categoryDtoMapper.requestToModel(request)).thenReturn(categoryModel);
        doNothing().when(categoryServicePort).save(categoryModel);

        SaveCategoryResponse response = categoryService.save(request);

        assertNotNull(response);
        verify(categoryDtoMapper, times(1)).requestToModel(request);
        verify(categoryServicePort, times(1)).save(categoryModel);
    }

    @Test
    void testGetCategories_Success() {
        List<CategoryModel> categoryModels = List.of(categoryModel);
        List<CategoryResponse> categoryResponses = List.of(new CategoryResponse(1L, "House", "A category for houses"));

        when(categoryServicePort.getCategories(0, 10, true)).thenReturn(categoryModels);
        when(categoryDtoMapper.modelListToResponseList(categoryModels)).thenReturn(categoryResponses);

        List<CategoryResponse> responses = categoryService.getCategories(0, 10, true);

        assertNotNull(responses);
        assertFalse(responses.isEmpty());
        assertEquals(1, responses.size());


        verify(categoryServicePort, times(1)).getCategories(0, 10, true);
        verify(categoryDtoMapper, times(1)).modelListToResponseList(categoryModels);
    }
}
