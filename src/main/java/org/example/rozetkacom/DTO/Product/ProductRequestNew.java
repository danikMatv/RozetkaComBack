package org.example.rozetkacom.DTO.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestNew {
    private String productName;
    private double price;
    private Long stockQuantity;
    private Long category;
}
