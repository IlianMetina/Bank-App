package com.myapp.ms_accounts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    private UUID customerId;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String bankAddress;
    private LocalDateTime createDate;
}
