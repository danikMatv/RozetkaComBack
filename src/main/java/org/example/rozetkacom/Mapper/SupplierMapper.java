package org.example.rozetkacom.Mapper;

import org.example.rozetkacom.DTO.Supplier.SupplierRequest;
import org.example.rozetkacom.DTO.Supplier.SupplierResponse;
import org.example.rozetkacom.Entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SupplierMapper {
    Supplier mapToSupplier(SupplierRequest supplierRequest);
    SupplierResponse mapToSupplierResponse(Supplier supplier);
    void updateSupplierFromRequest(SupplierRequest supplierRequest, @MappingTarget Supplier supplierToUpdate);
}
