package com.myapp.ms_cards.controller;

import com.myapp.ms_cards.model.Card;
import com.myapp.ms_cards.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service){
        this.service = service;
    }

    @GetMapping
    public List<Card> findAll(){
        return "Test réussi";
    }


}
