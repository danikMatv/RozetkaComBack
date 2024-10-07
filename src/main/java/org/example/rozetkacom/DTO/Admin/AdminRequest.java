package org.example.rozetkacom.DTO.Admin;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminRequest {
    private String name;
    private String password;
}
