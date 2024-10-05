package org.example.rozetkacom.Service;

import lombok.RequiredArgsConstructor;
import org.example.rozetkacom.DTO.Customer.CustomerRequest;
import org.example.rozetkacom.DTO.Customer.CustomerResponse;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Exeptions.NotFoundException;
import org.example.rozetkacom.Mapper.CustomerMapper;
import org.example.rozetkacom.Repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerResponse update(Long customerId, CustomerRequest customerRequest){
        Customer customerToUpdate = customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("For id " + customerId + " Customer not found "));
        customerMapper.updateCustomerFromRequest(customerRequest, customerToUpdate);
        return customerMapper.mapToCustomerResponse(customerRepository.save(customerToUpdate));
    }

    public CustomerResponse getCustomerById(Long customerId){
        return customerRepository.getCustomerById(customerId);
    }

    @Transactional
    public boolean deleteCustomerById(Long customerId){
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }

    public CustomerResponse loginCustomerByFirstNameAndPassword(String firstName,String password){
        CustomerResponse customerResponse = customerRepository.getCustomerByFirstNameAndPassword(firstName,password);
        if(customerResponse == null){
            throw new NotFoundException("Customer with name " + firstName + " and password " + password + " Not found ");
        }
        return customerResponse;
    }


    @Transactional
    public Customer save(CustomerRequest customerRequest){
        Customer customer = customerMapper.mapToCustomer(customerRequest);
        return customerRepository.save(customer);
    }
}
