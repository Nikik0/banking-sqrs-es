package com.nikik0.banking.service.card;

import com.nikik0.banking.domain.exception.ResourceNotFoundException;
import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService{

    private final CardRepository cardRepository;
    @Override
    public Card getById(UUID T) {
        return cardRepository.findById(T).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByNumberAndDate(String number, String date) {
        return cardRepository.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(String number, String date, String cvv) {
        return cardRepository.findByNumberAndDateAndCvv(number, date, cvv).orElseThrow(ResourceNotFoundException::new);
    }
}
