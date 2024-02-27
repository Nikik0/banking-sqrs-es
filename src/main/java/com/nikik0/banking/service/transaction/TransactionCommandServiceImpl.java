package com.nikik0.banking.service.transaction;

import com.nikik0.banking.domain.model.Transaction;
import com.nikik0.banking.event.TransactionCreateEvent;
import com.nikik0.banking.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService{

    private final EventService eventService;
    @Override
    public void create(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}
