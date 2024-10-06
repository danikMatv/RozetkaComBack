package org.example.rozetkacom.DTO.Orders;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class OrdersRequestNew {
    private double unitPrice;
    private String description;
    private int quantity;
    private Long customer;
    private Set<Long> products;
}
