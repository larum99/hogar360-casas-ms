package com.hogar360.houses.domain.model;

import com.hogar360.houses.houses.domain.exceptions.CategoryDescriptionMaxSizeExceededException;
import com.hogar360.houses.houses.domain.exceptions.CategoryNameMaxSizeExceededException;
import com.hogar360.houses.houses.domain.model.CategoryModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryModelTest {
    @Test
    void shouldThrowExceptionWhenNameExceedsMaxSize() {
        String longName = "a".repeat(51);
        assertThrows(CategoryNameMaxSizeExceededException.class, () -> new CategoryModel(1L, longName, "Valid description"));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionExceedsMaxSize() {
        String longDescription = "a".repeat(91);
        assertThrows(CategoryDescriptionMaxSizeExceededException.class, () -> new CategoryModel(1L, "Valid Name", longDescription));
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(NullPointerException.class, () -> new CategoryModel(1L, null, "Valid description"));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsNull() {
        assertThrows(NullPointerException.class, () -> new CategoryModel(1L, "Valid Name", null));
    }

    @Test
    void shouldCreateCategoryModelWhenValidDataIsProvided() {
        CategoryModel category = new CategoryModel(1L, "Valid Name", "Valid description");
        assertNotNull(category);
        assertEquals(1L, category.getId());
        assertEquals("Valid Name", category.getName());
        assertEquals("Valid description", category.getDescription());
    }
}
