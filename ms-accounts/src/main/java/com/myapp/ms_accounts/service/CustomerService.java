package com.myapp.ms_accounts.service;

import com.myapp.ms_accounts.client.CardsClient;
import com.myapp.ms_accounts.client.LoansClient;
import com.myapp.ms_accounts.dto.*;
import com.myapp.ms_accounts.model.Account;
import com.myapp.ms_accounts.model.Customer;
import com.myapp.ms_accounts.repository.AccountRepository;
import com.myapp.ms_accounts.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final LoansClient loansClient;
    private final CardsClient cardsClient;

    public CustomerService(CustomerRepository customerRepository, AccountRepository accountRepository, LoansClient loansClient, CardsClient cardsClient){
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.loansClient = loansClient;
        this.cardsClient = cardsClient;
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

        return customerRepository.save(customerToUpdate);
    }

    public void deleteCustomerById(UUID customerId){
        Customer customerToDelete = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customerToDelete);
    }

    public CustomerProfile getCustomerProfile(UUID customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        Account account = accountRepository.findByCustomerId(customerId).orElseThrow(() -> new RuntimeException("Account not found"));
        List<LoanResponse> loans = loansClient.getLoansByCustomerId(customerId);
        List<CardResponse> cards = cardsClient.getCardsByCustomerId(customerId);

        CustomerProfile profile = new CustomerProfile();
        profile.setCustomer(customer);
        profile.setAccount(account);
        profile.setCards(cards);
        profile.setLoans(loans);
        return profile;
    }
}
