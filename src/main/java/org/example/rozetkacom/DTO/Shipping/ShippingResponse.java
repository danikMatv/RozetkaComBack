package org.example.rozetkacom.DTO.Shipping;

import lombok.Builder;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Entity.Orders;

@Builder
public record ShippingResponse(
        Long id,
        String startPlace,
        String destination,
        int duration,
        Customer customer,
        Orders orders) {
}
