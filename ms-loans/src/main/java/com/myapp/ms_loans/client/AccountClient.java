package com.myapp.ms_loans.client;

import com.myapp.ms_loans.dto.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "ms-accounts")
public interface AccountClient {

    @GetMapping("/api/customers/{customerId}")
    CustomerResponse getCustomerById(@PathVariable UUID customerId);
}
