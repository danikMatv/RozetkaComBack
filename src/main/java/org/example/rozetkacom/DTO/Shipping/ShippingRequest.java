package org.example.rozetkacom.DTO.Shipping;

import lombok.Data;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Entity.Orders;

@Data
public class ShippingRequest {
    private String startPlace;
    private String destination;
    private int duration;
    private Customer customer;
    private Orders orders;
}
