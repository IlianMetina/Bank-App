package com.myapp.ms_accounts.controller;

import com.myapp.ms_accounts.dto.*;
import com.myapp.ms_accounts.model.Account;
import com.myapp.ms_accounts.model.Customer;
import com.myapp.ms_accounts.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("all")
    public List<Customer> findAll(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer findById(@PathVariable UUID customerId){
        return customerService.findCustomerById(customerId);
    }

    @PostMapping("add")
    public Customer addCustomer(@Valid @RequestBody CreateCustomerRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return customerService.addCustomer(dto);
    }

    @PutMapping("update/{customerId}")
    public Customer updateCustomer(@PathVariable UUID customerId, @Valid @RequestBody UpdateCustomerRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return customerService.updateCustomer(customerId, dto);
    }

    @DeleteMapping("delete/{customerId}")
    public void deleteCustomer(@PathVariable UUID customerId){
        customerService.deleteCustomerById(customerId);
    }

    @GetMapping("{customerId}/profile")
    public CustomerProfile getCustomerProfile(@PathVariable UUID customerId){
        return customerService.getCustomerProfile(customerId);
    }
}
