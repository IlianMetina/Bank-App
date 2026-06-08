package com.myapp.ms_cards.service;

import com.myapp.ms_cards.dto.CreateRequest;
import com.myapp.ms_cards.dto.UpdateRequest;
import com.myapp.ms_cards.model.Card;
import com.myapp.ms_cards.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository repository;

    public CardService(CardRepository repository){
        this.repository = repository;
    }

    public List<Card> findAll(){
        return repository.findAll();
    }

    public Card findCardById(UUID cardId){
        return repository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public Card addCard(CreateRequest dto){
        Card card = new Card();
        card.setCardNumber(dto.getCardNumber());
        card.setCardType(dto.getCardType());
        card.setAmountUsed(dto.getAmountUsed());
        card.setCreateDate(dto.getCreateDate());
        card.setAvailableAmount(dto.getAvailableAmount());
        card.setTotalAmount(dto.getTotalAmount());
        card.setCustomerId(dto.getCustomerId());

        return repository.save(card);
    }

    public Card updateCard(UUID cardId, UpdateRequest dto){
        Card cardToUpdate = repository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));
        cardToUpdate.setCardNumber(dto.getCardNumber());
        cardToUpdate.setCardType(dto.getCardType());
        cardToUpdate.setAmountUsed(dto.getAmountUsed());
        cardToUpdate.setCreateDate(dto.getCreateDate());
        cardToUpdate.setAvailableAmount(dto.getAvailableAmount());
        cardToUpdate.setTotalAmount(dto.getTotalAmount());
        cardToUpdate.setCustomerId(dto.getCustomerId());

        return repository.save(cardToUpdate);
    }

    public void deleteCardById(UUID cardId){
        Card cardToDelete = repository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));
        repository.delete(cardToDelete);
    }

    public List<Card> getCardsByCustomerId(UUID customerId) {
        return repository.findByCustomerId(customerId);
    }
}
