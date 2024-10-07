package org.example.rozetkacom.Service;

import lombok.RequiredArgsConstructor;
import org.example.rozetkacom.DTO.Orders.OrdersRequest;
import org.example.rozetkacom.DTO.Orders.OrdersRequestNew;
import org.example.rozetkacom.DTO.Orders.OrdersResponse;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Entity.Orders;
import org.example.rozetkacom.Entity.Product;
import org.example.rozetkacom.Exeptions.NotFoundException;
import org.example.rozetkacom.Mapper.OrdersMapper;
import org.example.rozetkacom.Repository.CustomerRepository;
import org.example.rozetkacom.Repository.OrdersRepository;
import org.example.rozetkacom.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrdersMapper ordersMapper;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrdersResponse update(Long ordersId, OrdersRequest uroductRequest){
        Orders ordersToUpdate = ordersRepository.findById(ordersId).orElseThrow(() -> new NotFoundException("For id " + ordersId + " Orders not found "));
        ordersMapper.updateOrdersFromRequest(uroductRequest,ordersToUpdate);
        return ordersMapper.mapToOrdersResponse(ordersRepository.save(ordersToUpdate));
    }

    public Orders getOrdersById(Long ordersId){
        return ordersRepository.getOrdersById(ordersId);
    }

    @Transactional
    public boolean deleteOrdersById(Long ordersId){
        if (ordersRepository.existsById(ordersId)) {
            ordersRepository.deleteById(ordersId);
            return true;
        }
        return false;
    }

    @Transactional
    public Orders save(OrdersRequestNew ordersRequestNew) {
        Customer customer = customerRepository.findById(ordersRequestNew.getCustomer())
                .orElseThrow(() -> new NotFoundException("Customer not found with id " + ordersRequestNew.getCustomer()));
        Set<Product> products = new HashSet<>();
        for (Long productId : ordersRequestNew.getProducts()) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new NotFoundException("Product not found with id " + productId));
            products.add(product);
        }
        OrdersRequest orders = new OrdersRequest();
        orders.setUnitPrice(ordersRequestNew.getUnitPrice());
        orders.setDescription(ordersRequestNew.getDescription());
        orders.setQuantity(ordersRequestNew.getQuantity());
        orders.setCustomer(customer);
        orders.setProducts(products);
        Orders ordersToMap = ordersMapper.mapToOrders(orders);
        return ordersRepository.save(ordersToMap);
    }

}
