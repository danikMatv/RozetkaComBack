package org.example.rozetkacom.Repository;

import org.example.rozetkacom.DTO.Product.ProductResponse;
import org.example.rozetkacom.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    ProductResponse getProductById(Long productId);
}
