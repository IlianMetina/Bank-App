package com.myapp.ms_loans.service;

import com.myapp.ms_loans.repository.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository repository;

    public LoanService(LoanRepository repository){
        this.repository = repository;
    }
}
