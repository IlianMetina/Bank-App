package com.myapp.ms_loans.dto;

import com.myapp.ms_loans.model.LoanType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateRequest {

    private LocalDateTime startDate;
    private LoanType loanType;
    private Long totalLoan;
    private Long amountPaid;
    private Long outstandingAmount;
    private LocalDateTime createDate;
}
