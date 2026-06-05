package com.myapp.ms_accounts.dto;

import com.myapp.ms_accounts.model.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateRequest {

    private AccountType accountType;
    private String bankAddress;
    private LocalDateTime createDate;
}
