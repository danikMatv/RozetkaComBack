package org.example.rozetkacom.Repository;

import org.example.rozetkacom.DTO.Customer.CustomerResponse;
import org.example.rozetkacom.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    CustomerResponse getCustomerById(Long id);

    CustomerResponse getCustomerByFirstNameAndPassword(String firstName,String password);

}
