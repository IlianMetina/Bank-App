package com.myapp.ms_accounts.dto;

import com.myapp.ms_accounts.model.Account;
import com.myapp.ms_accounts.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerProfile {

    private Customer customer;
    private Account account;
    private List<LoanResponse> loans;
    private List<CardResponse> cards;
}
