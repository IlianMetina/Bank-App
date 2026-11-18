package com.myapp.ms_accounts.controller;

import com.myapp.ms_accounts.dto.*;
import com.myapp.ms_accounts.model.Account;
import com.myapp.ms_accounts.model.Customer;
import com.myapp.ms_accounts.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private static final String CUSTOMER_ID_NULL_OR_EMPTY = "Customer id is null or empty";
    private static final String ORDER_SERVICE = "customerDetailsService";
    private static final String ORDER_FALLBACK = "getCustomerProfileFallback";
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

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

    @CircuitBreaker(name = ORDER_SERVICE, fallbackMethod = ORDER_FALLBACK)
    @GetMapping("{customerId}/profile")
    public CustomerProfile getCustomerProfile(@PathVariable UUID customerId){
        return customerService.getCustomerProfile(customerId);
    }


    public CustomerProfile getCustomerProfileFallback(UUID customerId, Throwable throwable){
//        System.out.println("======== getCustomerProfileFallback ========");
        return customerService.getCustomerProfileFallback(customerId);
    }

    public ResponseEntity<String> testRateLimiter(Throwable throwable){

    }

    private String getTestRateLimiter(Throwable throwable){
        System.out.println("Fallback test déclenchée. Cause : {}", throwable.getMessage());
        return "Test Rate Limiter. Trop de demandes. Merci de réessayer dans quelques instants.";
    }


}
