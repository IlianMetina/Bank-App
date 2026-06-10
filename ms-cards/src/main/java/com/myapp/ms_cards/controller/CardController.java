package com.myapp.ms_cards.controller;

import com.myapp.ms_cards.dto.CreateRequest;
import com.myapp.ms_cards.dto.UpdateRequest;
import com.myapp.ms_cards.model.Card;
import com.myapp.ms_cards.service.CardService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service){
        this.service = service;
    }

    @GetMapping("all")
    public List<Card> findAllCards(){
        return service.findAll();
    }

    @GetMapping("{cardId}")
    public Card findById(@PathVariable UUID cardId){
        return service.findCardById(cardId);
    }

    @PostMapping("add")
    public Card addCustomer(@Valid @RequestBody CreateRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return service.addCard(dto);
    }

    @PutMapping("update/{cardId}")
    public Card updateCard(@PathVariable UUID cardId, @Valid @RequestBody UpdateRequest dto, BindingResult result){
        if(result.hasErrors()) throw new RuntimeException("Invalid data");
        return service.updateCard(cardId, dto);
    }

    @DeleteMapping("delete/{cardId}")
    public void deleteAccount(@PathVariable UUID cardId){
        service.deleteCardById(cardId);
    }

    @GetMapping("customer/{customerId}")
    public List<Card> getCardsByCustomerId(@PathVariable UUID customerId){
        return service.getCardsByCustomerId(customerId);
    }
}
