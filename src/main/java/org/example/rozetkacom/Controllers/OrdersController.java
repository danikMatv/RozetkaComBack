package org.example.rozetkacom.Controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rozetkacom.DTO.Orders.OrdersRequest;
import org.example.rozetkacom.DTO.Orders.OrdersRequestNew;
import org.example.rozetkacom.DTO.Orders.OrdersResponse;
import org.example.rozetkacom.Entity.Orders;
import org.example.rozetkacom.Service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping("/{ordersId}")
    public OrdersResponse getOrdersById(@PathVariable Long ordersId) {
        return ordersService.getOrdersById(ordersId);
    }

    @PutMapping("/{ordersId}")
    public OrdersResponse updateOrdersById(@PathVariable Long ordersId, @Valid @RequestBody OrdersRequest ordersRequest) {
        return ordersService.update(ordersId, ordersRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orders createNewOrders(@Valid @RequestBody OrdersRequestNew ordersRequest) {
        return ordersService.save(ordersRequest);
    }

    @DeleteMapping("/{ordersId}")
    public void deleteOrdersById(@PathVariable Long ordersId) {
        ordersService.deleteOrdersById(ordersId);
    }

}