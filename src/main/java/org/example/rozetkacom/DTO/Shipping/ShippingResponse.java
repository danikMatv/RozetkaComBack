package org.example.rozetkacom.DTO.Shipping;

import lombok.Data;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Entity.Orders;

@Data
public record ShippingResponse(
        Long id,
        String startPlace,
        String destination,
        int duration,
        Customer customer,
        Orders orders) {
}
