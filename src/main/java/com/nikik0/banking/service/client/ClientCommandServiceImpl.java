package com.nikik0.banking.service.client;

import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.event.ClientCreatedEvent;
import com.nikik0.banking.service.event.EventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientCommandServiceImpl implements ClientCommandService{

    private final EventService eventService;
    @Override
    public void create(Client object) {
        ClientCreatedEvent event = new ClientCreatedEvent(object);
        eventService.create(event);
    }
}
