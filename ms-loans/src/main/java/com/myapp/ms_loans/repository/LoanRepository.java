package com.myapp.ms_loans.repository;

import com.myapp.ms_loans.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByCustomerId(UUID customerId);
}
