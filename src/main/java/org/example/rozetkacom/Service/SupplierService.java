package org.example.rozetkacom.Service;

import lombok.RequiredArgsConstructor;
import org.example.rozetkacom.DTO.Supplier.SupplierRequest;
import org.example.rozetkacom.DTO.Supplier.SupplierResponse;
import org.example.rozetkacom.Entity.Supplier;
import org.example.rozetkacom.Exeptions.NotFoundException;
import org.example.rozetkacom.Mapper.SupplierMapper;
import org.example.rozetkacom.Repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    private final SupplierMapper supplierMapper;

    @Transactional
    public SupplierResponse update(Long supplierId, SupplierRequest supplierRequest){
        Supplier supplierToUpdate = supplierRepository.findById(supplierId).orElseThrow(() -> new NotFoundException("For id " + supplierId + " Supplier not found "));
        supplierMapper.updateSupplierFromRequest(supplierRequest, supplierToUpdate);
        return supplierMapper.mapToSupplierResponse(supplierRepository.save(supplierToUpdate));
    }

    public SupplierResponse getSupplierById(Long supplierId){
        return supplierRepository.getSupplierById(supplierId);
    }

    @Transactional
    public boolean deleteSupplierById(Long supplierId){
        if (supplierRepository.existsById(supplierId)) {
            supplierRepository.deleteById(supplierId);
            return true;
        }
        return false;
    }

    @Transactional
    public Supplier save(SupplierRequest supplierRequest){
        Supplier supplier = supplierMapper.mapToSupplier(supplierRequest);
        return supplierRepository.save(supplier);
    }
    
}
