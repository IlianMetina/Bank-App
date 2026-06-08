package com.myapp.ms_accounts.client;

import com.myapp.ms_accounts.dto.CardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ms-cards")
public interface CardsClient {

    @GetMapping("/api/cards/customer/{customerId}")
    List<CardResponse> getCardsByCustomerId(@PathVariable UUID customerId);
}
