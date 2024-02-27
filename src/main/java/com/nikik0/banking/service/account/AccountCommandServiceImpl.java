package com.nikik0.banking.service.account;

import com.nikik0.banking.domain.model.Account;
import com.nikik0.banking.event.AccountCreateEvent;
import com.nikik0.banking.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;
    @Override
    public void create(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}
