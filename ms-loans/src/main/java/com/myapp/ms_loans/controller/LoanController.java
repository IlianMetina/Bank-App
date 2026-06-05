package com.myapp.ms_loans.controller;

import com.myapp.ms_loans.dto.CreateRequest;
import com.myapp.ms_loans.dto.UpdateRequest;
import com.myapp.ms_loans.model.Loan;
import com.myapp.ms_loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/loans")
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service){
        this.service = service;
    }

    @PostMapping("add")
    public Loan addLoan(@Valid @RequestBody CreateRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return service.addLoan(dto);
    }

    @GetMapping("all")
    public List<Loan> findAll(){
        return service.findAllLoans();
    }

    @GetMapping("{loanNumber}")
    public Loan findLoanById(@PathVariable Long loanNumber){
        return service.findLoanById(loanNumber);
    }

    @PutMapping("update/{loanNumber}")
    public Loan updateLoan(@PathVariable Long loanNumber, @Valid @RequestBody UpdateRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return service.updateLoan(loanNumber, dto);
    }

    @DeleteMapping("delete")
    public void deleteLoan(@RequestBody Long loanNumber){
        service.deleteLoanById(loanNumber);
    }

}
