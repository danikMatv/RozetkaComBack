package org.example.rozetkacom.Repository;

import org.example.rozetkacom.DTO.Supplier.SupplierResponse;
import org.example.rozetkacom.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    SupplierResponse getSupplierById(Long Id);
}
