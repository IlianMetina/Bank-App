package com.myapp.ms_cards.repository;

import com.myapp.ms_cards.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
