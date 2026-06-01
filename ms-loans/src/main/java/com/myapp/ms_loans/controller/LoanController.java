package com.myapp.ms_loans.controller;

import com.myapp.ms_loans.service.LoanService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service){
        this.service = service;
    }
}
