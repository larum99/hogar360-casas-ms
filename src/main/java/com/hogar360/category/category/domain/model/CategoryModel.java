package com.hogar360.category.category.domain.model;

import com.hogar360.category.category.domain.exceptions.DescriptionMaxSizeExceededException;
import com.hogar360.category.category.domain.exceptions.NameMaxSizeExceededException;
import com.hogar360.category.category.domain.utils.constants.DomainConstants;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class CategoryModel {
    @Setter
    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        if (name.length() > 50) throw new NameMaxSizeExceededException();
        if (description.length() > 90) throw new DescriptionMaxSizeExceededException();
        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public void setName(String name) {
        if (name.length() > 50) throw new NameMaxSizeExceededException();
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public void setDescription(String description) {
        if (description.length() > 90) throw new DescriptionMaxSizeExceededException();
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }
}
