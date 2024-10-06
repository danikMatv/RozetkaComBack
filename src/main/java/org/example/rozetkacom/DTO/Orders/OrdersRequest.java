package org.example.rozetkacom.DTO.Orders;

import lombok.Builder;
import lombok.Data;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Entity.Product;

import java.util.Set;

@Builder
@Data
public class OrdersRequest {
    private double unitPrice;
    private String description;
    private int quantity;
    private Customer customer;
    private Set<Product> products;
}
