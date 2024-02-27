package com.nikik0.banking.service.event;

import com.nikik0.banking.event.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);
}
