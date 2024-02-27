package com.nikik0.banking.service.card;

import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.service.QueryService;

import java.util.Optional;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);
}
