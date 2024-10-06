package org.example.rozetkacom.DTO.Supplier;

import lombok.Builder;

@Builder
public record SupplierResponse(Long id,

                               String supplierName,
                               String contactEmail,
                               String contactPhone) {
}
