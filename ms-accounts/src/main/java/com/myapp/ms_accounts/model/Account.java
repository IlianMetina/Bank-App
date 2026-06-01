package com.myapp.ms_accounts.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Account {

    private UUID customerId;
    private Long accountNumber;
    private AccountType accountType;
    private String bankAddress;
    private LocalDateTime createDate;
}
