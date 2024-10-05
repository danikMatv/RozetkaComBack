package org.example.rozetkacom.DTO.Product;

import lombok.Builder;

@Builder
public record ProductResponse(
        Long id,
        String productName,
        double price,
        Long stockQuantity,
        String category) {
}
