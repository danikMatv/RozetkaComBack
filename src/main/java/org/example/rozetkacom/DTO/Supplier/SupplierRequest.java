package org.example.rozetkacom.DTO.Supplier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplierRequest {
    private String supplierName;
    private String contactEmail;
    private String contactPhone;

}
