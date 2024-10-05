package org.example.rozetkacom.Mapper;

import org.example.rozetkacom.DTO.Category.CategoryRequest;
import org.example.rozetkacom.DTO.Category.CategoryResponse;
import org.example.rozetkacom.Entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CategoryMapper {
    Category mapToCategory(CategoryRequest categoryRequest);
    CategoryResponse mapToCategoryResponse(Category category);
    void updateCategoryFromRequest(CategoryRequest categoryRequest, @MappingTarget Category categoryToUpdate);
}
