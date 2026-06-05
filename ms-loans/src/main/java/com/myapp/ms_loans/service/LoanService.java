package com.myapp.ms_loans.service;

import com.myapp.ms_loans.dto.CreateRequest;
import com.myapp.ms_loans.dto.UpdateRequest;
import com.myapp.ms_loans.model.Loan;
import com.myapp.ms_loans.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository repository;

    public LoanService(LoanRepository repository){
        this.repository = repository;
    }

    public List<Loan> findAllLoans(){
        return repository.findAll();
    }

    public Loan findLoanById(Long loanNumber){
        return repository.findById(loanNumber).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public Loan addLoan(CreateRequest dto){
        Loan loan = new Loan();
        loan.setStartDate(dto.getStartDate());
        loan.setLoanType(dto.getLoanType());
        loan.setTotalLoan(dto.getTotalLoan());
        loan.setAmountPaid(dto.getAmountPaid());
        loan.setOutstandingAmount(dto.getOutstandingAmount());
        loan.setCreateDate(dto.getCreateDate());
        return repository.save(loan);
    }

    public Loan updateLoan(Long loanNumber, UpdateRequest dto){

        Loan loanToUpdate = repository.findById(loanNumber).orElseThrow(() -> new RuntimeException("Loan not found"));
        loanToUpdate.setStartDate(dto.getStartDate());
        loanToUpdate.setLoanType(dto.getLoanType());
        loanToUpdate.setTotalLoan(dto.getTotalLoan());
        loanToUpdate.setAmountPaid(dto.getAmountPaid());
        loanToUpdate.setOutstandingAmount(dto.getOutstandingAmount());
        loanToUpdate.setCreateDate(dto.getCreateDate());

        return repository.save(loanToUpdate);
    }

    public void deleteLoanById(Long loanNumber){
        repository.deleteById(loanNumber);
    }
}
