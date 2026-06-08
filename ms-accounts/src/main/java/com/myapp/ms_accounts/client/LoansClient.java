package com.myapp.ms_accounts.client;

import com.myapp.ms_accounts.dto.LoanResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ms-loans")
public interface LoansClient {

    @GetMapping("/api/loans/customer/{customerId}")
    List<LoanResponse> getLoansByCustomerId(@PathVariable UUID customerId);
}
