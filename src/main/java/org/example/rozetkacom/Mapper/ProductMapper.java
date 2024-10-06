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
}