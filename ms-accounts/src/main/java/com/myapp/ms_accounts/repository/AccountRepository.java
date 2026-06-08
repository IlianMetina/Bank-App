package com.myapp.ms_accounts.repository;

import com.myapp.ms_accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(Long accountNumber);
    Optional<Account> findByCustomerId(UUID customerId);
}
