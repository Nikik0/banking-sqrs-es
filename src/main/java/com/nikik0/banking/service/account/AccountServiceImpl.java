package com.nikik0.banking.service.account;

import com.nikik0.banking.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountQueryService accountQueryService;

    private final AccountCommandService accountCommandService;

    @Override
    public void create(Account object) {
        accountCommandService.create(object);
    }

    @Override
    public Account getById(UUID T) {
        return accountQueryService.getById(T);
    }
}
