package com.myapp.ms_accounts.controller;

import com.myapp.ms_accounts.dto.CreateAccountRequest;
import com.myapp.ms_accounts.dto.CreateCustomerRequest;
import com.myapp.ms_accounts.dto.UpdateAccountRequest;
import com.myapp.ms_accounts.dto.UpdateCustomerRequest;
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

    @GetMapping
    public Customer findById(@RequestBody UUID customerId){
        return customerService.findCustomerById(customerId);
    }

    @PostMapping("add")
    public Customer addCustomer(@Valid @RequestBody CreateCustomerRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return customerService.addCustomer(dto);
    }

    @PutMapping("update/{accountNumber}")
    public Account updateAccount(@PathVariable Long customerId, @Valid @RequestBody UpdateCustomerRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return customerService.updateCustomer(customerId, dto);
    }

    @DeleteMapping("delete/{accountNumber}")
    public void deleteAccount(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }
}
