package com.nikik0.banking.service.card;

import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.service.CommandService;
import com.nikik0.banking.service.QueryService;

import java.util.UUID;

public interface CardService extends CommandService<Card>, QueryService<Card> {

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
