package com.myapp.ms_loans.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerResponse {

    private UUID customerId;
    private String firstName;
    private String lastName;
}
