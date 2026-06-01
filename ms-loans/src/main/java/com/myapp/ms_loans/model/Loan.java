package com.myapp.ms_loans.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Loan {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long loanNumber;
    private UUID customerId;
    private LocalDateTime startDate; // Date de prélèvement
    private LoanType loanType;
    private Long totalLoan;
    private Long amountPaid;
    private Long outstandingAmount;
    private LocalDateTime createDate;

}
