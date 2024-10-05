package org.example.rozetkacom.DTO.Product;

import lombok.Builder;
import lombok.Data;
import org.example.rozetkacom.Entity.Category;

@Data
@Builder
public class UpdateProductRequest {
    private String productName;
    private double price;
    private Long stockQuantity;
    private Category category;
}
