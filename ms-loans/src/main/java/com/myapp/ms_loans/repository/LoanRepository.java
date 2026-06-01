package com.myapp.ms_loans.repository;

import com.myapp.ms_loans.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
