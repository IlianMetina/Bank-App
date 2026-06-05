package com.myapp.ms_accounts.controller;

import com.myapp.ms_accounts.dto.CreateRequest;
import com.myapp.ms_accounts.model.Account;
import com.myapp.ms_accounts.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("all")
    public List<Account> findAll(){
        return accountService.findAllAccounts();
    }

    @GetMapping("{accountNumber}")
    public Account findById(@PathVariable Long accountNumber){
        return accountService.findAccountById(accountNumber);
    }

    @PostMapping("add")
    public Account addAccount(@Valid @RequestBody CreateRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return accountService.addAccount(dto);
    }


}
