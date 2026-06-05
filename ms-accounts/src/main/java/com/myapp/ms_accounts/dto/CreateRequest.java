package com.myapp.ms_accounts.dto;

import com.myapp.ms_accounts.model.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CreateRequest {

    private UUID customerId;
    private AccountType accountType;
    private String bankAddress;
    private LocalDateTime createDate;
}
