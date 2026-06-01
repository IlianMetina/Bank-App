package com.myapp.ms_cards.controller;

import com.myapp.ms_cards.service.CardService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    private final CardService service;

    public CardController(CardService service){
        this.service = service;
    }
}
