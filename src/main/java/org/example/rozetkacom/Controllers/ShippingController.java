package org.example.rozetkacom.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rozetkacom.DTO.Shipping.ShippingRequest;
import org.example.rozetkacom.DTO.Shipping.ShippingRequestNew;
import org.example.rozetkacom.DTO.Shipping.ShippingResponse;
import org.example.rozetkacom.Entity.Shipping;
import org.example.rozetkacom.Service.ShippingService;
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
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    @GetMapping("/{shippingId}")
    public ShippingResponse getShippingById(@PathVariable Long shippingId){
        return shippingService.getShippingById(shippingId);
    }

    @PutMapping("/{shippingId}")
    public ShippingResponse updateShippingById(@PathVariable Long shippingId, @Valid @RequestBody ShippingRequest shippingRequest){
        return shippingService.update(shippingId, shippingRequest);
    }

    @PostMapping("/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Shipping createNewShipping(@PathVariable Long orderId,@Valid @RequestBody ShippingRequestNew shippingRequest){
        return shippingService.save(shippingRequest,orderId);
    }

    @DeleteMapping("/{shippingId}")
    public void deleteShippingById(@PathVariable Long shippingId){
        shippingService.deleteShippingById(shippingId);
    }

}