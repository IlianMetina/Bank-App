package com.myapp.ms_accounts.dto;

import com.myapp.ms_accounts.model.LoanType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class LoanResponse {

    private Long loanNumber;
    private UUID customerId;
    private LocalDateTime startDate;
    private LoanType loanType;
    private Long totalLoan;
    private Long amountPaid;
    private Long outstandingAmount;

}
