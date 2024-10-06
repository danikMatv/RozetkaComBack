package org.example.rozetkacom.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rozetkacom.DTO.Customer.CustomerLoginRequest;
import org.example.rozetkacom.DTO.Customer.CustomerRequest;
import org.example.rozetkacom.DTO.Customer.CustomerResponse;
import org.example.rozetkacom.Entity.Customer;
import org.example.rozetkacom.Service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{customerId}")
    public CustomerResponse getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerResponse updateCustomerById(@PathVariable Long customerId, @Valid @RequestBody CustomerRequest customerRequest){
        return customerService.update(customerId, customerRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createNewCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        return customerService.save(customerRequest);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }

    @PostMapping("/login")
    public CustomerResponse loginCustomer(@RequestBody CustomerLoginRequest loginRequest) {
        return customerService.loginCustomerByFirstNameAndPassword(loginRequest.getFirstName(), loginRequest.getPassword());
    }
}
