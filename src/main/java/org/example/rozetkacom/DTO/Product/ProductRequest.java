package org.example.rozetkacom.DTO.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.example.rozetkacom.Entity.Category;
import org.example.rozetkacom.Entity.Orders;

import java.util.Set;

@Data
@Builder
public class ProductRequest {
    private String productName;
    private double price;
    private Long stockQuantity;
    private String category;
}
