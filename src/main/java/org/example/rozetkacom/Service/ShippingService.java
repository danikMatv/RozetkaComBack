package org.example.rozetkacom.Service;

import lombok.RequiredArgsConstructor;
import org.example.rozetkacom.DTO.Shipping.ShippingRequest;
import org.example.rozetkacom.DTO.Shipping.ShippingRequestNew;
import org.example.rozetkacom.DTO.Shipping.ShippingResponse;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Entity.Orders;
import org.example.rozetkacom.Entity.Shipping;
import org.example.rozetkacom.Exeptions.NotFoundException;
import org.example.rozetkacom.Mapper.ShippingMapper;
import org.example.rozetkacom.Repository.CustomerRepository;
import org.example.rozetkacom.Repository.OrdersRepository;
import org.example.rozetkacom.Repository.ShippingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShippingService {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;
    private final CustomerRepository customerRepository;
    private final OrdersRepository ordersRepository;

    @Transactional
    public ShippingResponse update(Long shippingId, ShippingRequest shippingRequest) {
        Shipping shippingToUpdate = shippingRepository.findById(shippingId).orElseThrow(() -> new NotFoundException("For id " + shippingId + " Shipping not found "));
        shippingMapper.updateShippingFromRequest(shippingRequest, shippingToUpdate);
        return shippingMapper.mapToShippingResponse(shippingRepository.save(shippingToUpdate));
    }

    public ShippingResponse getShippingById(Long shippingId) {
        return shippingRepository.getShippingById(shippingId);
    }

    @Transactional
    public boolean deleteShippingById(Long shippingId) {
        if (shippingRepository.existsById(shippingId)) {
            shippingRepository.deleteById(shippingId);
            return true;
        }
        return false;
    }

    @Transactional
    public Shipping save(ShippingRequestNew shippingRequestNew) {
        Orders orders = ordersRepository.findById(shippingRequestNew.getOrders()).orElseThrow(() -> new NotFoundException("Order with id "
                + shippingRequestNew.getOrders() + " not found "));
        Customer customer = customerRepository.findById(shippingRequestNew.getCustomer()).orElseThrow(() -> new NotFoundException("Customer with id "
                + shippingRequestNew.getCustomer() + " not found "));
        ShippingRequest oldShipping = new ShippingRequest();
        oldShipping.setCustomer(customer);
        oldShipping.setDestination(shippingRequestNew.getDestination());
        oldShipping.setOrders(orders);
        oldShipping.setStartPlace(shippingRequestNew.getStartPlace());
        oldShipping.setDuration(shippingRequestNew.getDuration());
        Shipping shipping = shippingMapper.mapToShipping(oldShipping);
        return shippingRepository.save(shipping);
    }
}