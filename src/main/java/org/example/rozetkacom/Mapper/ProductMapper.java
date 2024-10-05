package org.example.rozetkacom.Mapper;

import org.example.rozetkacom.DTO.Product.ProductRequest;
import org.example.rozetkacom.DTO.Product.ProductResponse;
import org.example.rozetkacom.DTO.Product.UpdateProductRequest;
import org.example.rozetkacom.Entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product mapToProduct(ProductRequest productRequest);
    ProductResponse mapToProductResponse(Product product);

    void updateProductFromRequest(UpdateProductRequest updateProductRequest, @MappingTarget Product product);

//    @Mappings({
//            @Mapping(source = "category", target = "category")
//    })
//    default Category map(String categoryId) {
//        if (categoryId == null || categoryId.isEmpty()) {
//            return null; // Handle null or empty case as needed
//        }
//        Category category = new Category();
//        category.setId(Long.parseLong(categoryId)); // Assuming categoryId is a String representation of a Long
//        return category; // Return the new Category instance
//    }
}