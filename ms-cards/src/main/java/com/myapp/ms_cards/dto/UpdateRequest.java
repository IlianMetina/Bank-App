package com.myapp.ms_cards.dto;

import com.myapp.ms_cards.model.CardType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UpdateRequest {

    private UUID customerId;
    private Long cardNumber;
    private CardType cardType;
    private Long totalAmount;
    private Long amountUsed;
    private Long availableAmount;
    private LocalDateTime createDate;
}
