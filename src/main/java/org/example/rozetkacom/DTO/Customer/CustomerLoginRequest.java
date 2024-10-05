package org.example.rozetkacom.DTO.Customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerLoginRequest {
    private String firstName;
    private String password;
}
