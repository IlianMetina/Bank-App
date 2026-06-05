package com.myapp.ms_accounts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Account {


    @Id
    private Long accountNumber;
    private UUID customerId;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String bankAddress;
    private LocalDateTime createDate;
}
