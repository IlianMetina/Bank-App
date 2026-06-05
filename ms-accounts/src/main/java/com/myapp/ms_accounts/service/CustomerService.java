package com.myapp.ms_accounts.service;

import com.myapp.ms_accounts.dto.CreateCustomerRequest;
import com.myapp.ms_accounts.dto.UpdateCustomerRequest;
import com.myapp.ms_accounts.model.Customer;
import com.myapp.ms_accounts.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(UUID customerId){
        return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(CreateCustomerRequest dto){
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setCreateDate(dto.getCreateDate());

        return customerRepository.save(customer);
    }

    public Customer updateCustomer(UUID customerId, UpdateCustomerRequest dto){
        Customer customerToUpdate = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerToUpdate.setFirstName(dto.getFirstName());
        customerToUpdate.setLastName(dto.getLastName());
        customerToUpdate.setEmail(dto.getEmail());
        customerToUpdate.setPhoneNumber(dto.getPhoneNumber());
        customerToUpdate.setCreateDate(dto.getCreateDate());
    }
}
