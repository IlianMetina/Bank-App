package com.myapp.ms_cards.service;

import com.myapp.ms_cards.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository repository;

    public CardService(CardRepository repository){
        this.repository = repository;
    }
}
