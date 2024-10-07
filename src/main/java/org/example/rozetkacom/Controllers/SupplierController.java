package org.example.rozetkacom.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rozetkacom.DTO.Supplier.SupplierRequest;
import org.example.rozetkacom.DTO.Supplier.SupplierResponse;
import org.example.rozetkacom.Entity.Supplier;
import org.example.rozetkacom.Service.SupplierService;
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
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("/{supplierId}")
    public SupplierResponse getSupplierById(@PathVariable Long supplierId){
        return supplierService.getSupplierById(supplierId);
    }

    @PutMapping("/{supplierId}")
    public SupplierResponse updateSupplierById(@PathVariable Long supplierId, @Valid @RequestBody SupplierRequest supplierRequest){
        return supplierService.update(supplierId, supplierRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier createNewSupplier(@Valid @RequestBody SupplierRequest supplierRequest){
        return supplierService.save(supplierRequest);
    }

    @DeleteMapping("/{supplierId}")
    public void deleteSupplierById(@PathVariable Long supplierId){
        supplierService.deleteSupplierById(supplierId);
    }


}
