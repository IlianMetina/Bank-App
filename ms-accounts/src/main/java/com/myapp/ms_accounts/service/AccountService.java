package com.myapp.ms_accounts.service;

import com.myapp.ms_accounts.dto.CreateAccountRequest;
import com.myapp.ms_accounts.dto.UpdateAccountRequest;
import com.myapp.ms_accounts.model.Account;
import com.myapp.ms_accounts.model.Properties;
import com.myapp.ms_accounts.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }

    public Account findAccountById(Long accountNumber){
        return accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account addAccount(CreateAccountRequest dto){
        Account account = new Account();
        account.setCustomerId(dto.getCustomerId());
        account.setCreateDate(dto.getCreateDate());
        account.setAccountType(dto.getAccountType());
        account.setBankAddress(dto.getBankAddress());
        account.setCreateDate(dto.getCreateDate());

        return accountRepository.save(account);
    }

    public Account updateAccount(Long accountNumber, UpdateAccountRequest dto){
        Account accountToUpdate = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new RuntimeException("Account not found"));
        accountToUpdate.setAccountType(dto.getAccountType());
        accountToUpdate.setBankAddress(dto.getBankAddress());
        accountToUpdate.setCreateDate(dto.getCreateDate());

        return accountRepository.save(accountToUpdate);
    }

    public void deleteAccountById(Long accountNumber){
        Account accountToDelete = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.delete(accountToDelete);
    }
}
