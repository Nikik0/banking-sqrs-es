package com.nikik0.banking.service.card;

import com.nikik0.banking.domain.model.Card;

import java.util.UUID;

public interface CardService extends CardQueryService, CardCommandService{

    void createByUserId(UUID userId);

    boolean existsByNumberAndDate(
            String number,
            String date
    );

    Card getByNumberAndDateAndCvv(
            String number,
            String date,
            String cvv
    );
}
