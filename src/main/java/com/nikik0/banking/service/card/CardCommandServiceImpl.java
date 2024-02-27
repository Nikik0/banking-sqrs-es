package com.nikik0.banking.service.card;

import com.nikik0.banking.domain.model.Card;
import com.nikik0.banking.event.CardCreatedEvent;
import com.nikik0.banking.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardCommandServiceImpl implements CardCommandService{

    private final EventService eventService;
    @Override
    public void create(Card object) {
        CardCreatedEvent event = new CardCreatedEvent(object);
        eventService.create(event);
    }
}
