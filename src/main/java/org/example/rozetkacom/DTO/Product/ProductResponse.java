package org.example.rozetkacom.DTO.Product;

import lombok.Builder;
import org.example.rozetkacom.Entity.Category;

@Builder
public record ProductResponse(
        Long id,
        String productName,
        double price,
        Long stockQuantity,
        Category category) {
}
