package org.example.rozetkacom.Repository;

import org.example.rozetkacom.DTO.Shipping.ShippingResponse;
import org.example.rozetkacom.Entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping,Long> {
    ShippingResponse getShippingById(Long id);
}
