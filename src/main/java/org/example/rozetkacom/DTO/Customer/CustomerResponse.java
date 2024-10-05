package org.example.rozetkacom.DTO.Customer;

import lombok.Builder;

@Builder
public record CustomerResponse(int id,
                               String firstName,
                               String lastName,
                               String email,
                               String phoneNumber) {
}
