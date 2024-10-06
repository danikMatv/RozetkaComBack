package org.example.rozetkacom.Mapper;

import org.example.rozetkacom.DTO.Orders.OrdersRequest;
import org.example.rozetkacom.DTO.Orders.OrdersResponse;
import org.example.rozetkacom.Entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface OrdersMapper {
    Orders mapToOrders(OrdersRequest ordersRequest);
    OrdersResponse mapToOrdersResponse(Orders orders);
    void updateOrdersFromRequest(OrdersRequest ordersRequest, @MappingTarget Orders ordersToUpdate);
}
