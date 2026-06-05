package com.myapp.ms_accounts.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime createDate;
}
