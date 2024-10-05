package org.example.rozetkacom.DTO.Customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
