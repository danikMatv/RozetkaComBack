package org.example.rozetkacom.DTO.Orders;

import lombok.Builder;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Entity.Product;

import java.util.Set;

@Builder
public record OrdersResponse(Long id,
                             double unitPrice,
                             String description,
                             int quantity,
                             Customer customer,
                             Set<Product> products) {
}
