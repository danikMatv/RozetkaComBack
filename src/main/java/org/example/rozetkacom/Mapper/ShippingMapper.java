package org.example.rozetkacom.Mapper;

import org.example.rozetkacom.DTO.Shipping.ShippingRequest;
import org.example.rozetkacom.DTO.Shipping.ShippingResponse;
import org.example.rozetkacom.Entity.Shipping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ShippingMapper {
    Shipping mapToShipping(ShippingRequest shippingRequest);
    ShippingResponse mapToShippingResponse(Shipping shipping);
    void updateShippingFromRequest(ShippingRequest shippingRequest, @MappingTarget Shipping shippingToUpdate);
}