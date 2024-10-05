package org.example.rozetkacom.Mapper;

import org.example.rozetkacom.DTO.Customer.CustomerRequest;
import org.example.rozetkacom.DTO.Customer.CustomerResponse;
import org.example.rozetkacom.Entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CustomerMapper {
    Customer mapToCustomer(CustomerRequest customerRequest);
    CustomerResponse mapToCustomerResponse(Customer customer);
    void updateCustomerFromRequest(CustomerRequest customerRequest, @MappingTarget Customer customerToUpdate);
}