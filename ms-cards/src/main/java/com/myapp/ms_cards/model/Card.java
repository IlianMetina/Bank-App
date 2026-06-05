package com.myapp.ms_cards.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Card {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID cardId;
    private UUID customerId;
    private Long cardNumber;
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private Long totalAmount;
    private Long amountUsed;
    private Long availableAmount;
    private LocalDateTime createDate;

}
