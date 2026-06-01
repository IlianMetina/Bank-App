package com.myapp.ms_cards.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Card {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private UUID cardId;
    private UUID customerId;
    private Long cardNumber;
    private CardType cardType;
    private Long totalAmount;
    private Long amountUsed;
    private Long availableAmount;
    private LocalDateTime createDate;

}
