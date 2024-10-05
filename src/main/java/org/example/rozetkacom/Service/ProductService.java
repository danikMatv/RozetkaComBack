package org.example.rozetkacom.Service;

import lombok.RequiredArgsConstructor;
import org.example.rozetkacom.DTO.Product.ProductRequest;
import org.example.rozetkacom.DTO.Product.ProductResponse;
import org.example.rozetkacom.DTO.Product.UpdateProductRequest;
import org.example.rozetkacom.Entity.Product;
import org.example.rozetkacom.Exeptions.NotFoundException;
import org.example.rozetkacom.Mapper.ProductMapper;
import org.example.rozetkacom.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductResponse update(Long productId, UpdateProductRequest uroductRequest){
        Product productToUpdate = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("For id " + productId + " Product not found "));
        productMapper.updateProductFromRequest(uroductRequest,productToUpdate);
        return productMapper.mapToProductResponse(productRepository.save(productToUpdate));
    }

    public ProductResponse getProductById(Long productId){
        return productRepository.getProductById(productId);
    }

    @Transactional
    public boolean deleteProductById(Long productId){
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Transactional
    public Product save(ProductRequest productRequest){
        Product product = productMapper.mapToProduct(productRequest);
        return productRepository.save(product);
    }
}
