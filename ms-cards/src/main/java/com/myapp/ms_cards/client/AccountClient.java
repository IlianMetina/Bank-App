package com.myapp.ms_cards.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-cards")
public interface AccountClient {
}
