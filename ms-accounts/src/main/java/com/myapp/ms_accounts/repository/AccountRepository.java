package com.myapp.ms_accounts.repository;

import com.myapp.ms_accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Account findById(Long accountNumber);
}
