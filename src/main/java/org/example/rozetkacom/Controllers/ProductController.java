package org.example.rozetkacom.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rozetkacom.DTO.Product.ProductRequestNew;
import org.example.rozetkacom.DTO.Product.ProductResponse;
import org.example.rozetkacom.DTO.Product.UpdateProductRequest;
import org.example.rozetkacom.Entity.Product;
import org.example.rozetkacom.Service.ProductService;
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

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ProductResponse getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/{productId}")
    public ProductResponse updateProductById(@PathVariable Long productId, @Valid @RequestBody UpdateProductRequest productRequest) {
        return productService.update(productId, productRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(@Valid @RequestBody ProductRequestNew productRequest) {
        return productService.save(productRequest);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }

    @GetMapping
    private List<Product> getAll(){
        return productService.getAll();
    }
}
