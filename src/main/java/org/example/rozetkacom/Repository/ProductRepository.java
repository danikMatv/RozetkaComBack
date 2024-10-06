package org.example.rozetkacom.Repository;

import org.example.rozetkacom.DTO.Product.ProductResponse;
import org.example.rozetkacom.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    ProductResponse getProductById(Long productId);
    @Query("SELECT c FROM Product c")
    List<Product> getAll();
}
