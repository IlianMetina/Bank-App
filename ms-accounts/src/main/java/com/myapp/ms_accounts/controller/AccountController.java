package com.myapp.ms_accounts.controller;

import com.myapp.ms_accounts.config.AccountConfig;
import com.myapp.ms_accounts.dto.CreateAccountRequest;
import com.myapp.ms_accounts.dto.UpdateAccountRequest;
import com.myapp.ms_accounts.model.Account;
import com.myapp.ms_accounts.model.Properties;
import com.myapp.ms_accounts.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountConfig config;

    public AccountController(AccountService accountService, AccountConfig config){
        this.accountService = accountService;
        this.config = config;
    }

    @GetMapping("all")
    public List<Account> findAll(){
        return accountService.findAllAccounts();
    }

    @GetMapping("/details/properties")
    public ResponseEntity<Properties> getProperties(){
        Properties properties = new Properties(config.getName(), config.getMessage(), config.getBuildVersion(), config.getMailDetails(), config.getActivesBranches());
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping("{accountNumber}")
    public Account findById(@PathVariable Long accountNumber){
        return accountService.findAccountById(accountNumber);
    }

    @PostMapping("add")
    public Account addAccount(@Valid @RequestBody CreateAccountRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return accountService.addAccount(dto);
    }

    @PutMapping("update/{accountNumber}")
    public Account updateAccount(@PathVariable Long accountNumber, @Valid @RequestBody UpdateAccountRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return accountService.updateAccount(accountNumber, dto);
    }

    @DeleteMapping("delete/{accountNumber}")
    public void deleteAccount(@PathVariable Long accountNumber){
        accountService.deleteAccountById(accountNumber);
    }

}
