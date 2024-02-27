package com.nikik0.banking.service.event;

import com.nikik0.banking.event.AbstractEvent;
import com.nikik0.banking.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;

    @Override
    public void create(AbstractEvent event) {
        eventRepository.save(event);
    }
}
