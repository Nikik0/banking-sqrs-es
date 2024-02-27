package com.nikik0.banking.service.card;

import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

    private final CardCommandService cardCommandService;
    private final ClientService clientService;
    private final CardQueryService cardQueryService;

    @Override
    public void create(Card object) {
        cardCommandService.create(object);
    }

    @Override
    public Card getById(UUID T) {
        return cardQueryService.getById(T);
    }

    @Override
    public void createByUserId(UUID userId) {
        Client client = clientService.getById(userId);
        Card card = new Card(client.getAccount());
        cardCommandService.create(card);
    }

    @Override
    public boolean existsByNumberAndDate(String number, String date) {
        return cardQueryService.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(String number, String date, String cvv) {
        return cardQueryService.getByNumberAndDateAndCvv(number, date, cvv);
    }
}
