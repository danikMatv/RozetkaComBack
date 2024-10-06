package org.example.rozetkacom.DTO.Shipping;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingRequestNew {
    private String startPlace;
    private String destination;
    private int duration;
    private Long customer;
    private Long orders;
}
