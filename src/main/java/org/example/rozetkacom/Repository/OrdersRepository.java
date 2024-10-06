package org.example.rozetkacom.Repository;

import org.example.rozetkacom.DTO.Orders.OrdersResponse;
import org.example.rozetkacom.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
    OrdersResponse getOrdersById(Long id);
}
