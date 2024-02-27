package com.nikik0.banking.service.account;

import com.nikik0.banking.domain.exception.ResourceNotFoundException;
import com.nikik0.banking.domain.model.Account;
import com.nikik0.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService{

    private final AccountRepository accountRepository;
    @Override
    public Account getById(UUID T) {
        return accountRepository.findById(T).orElseThrow(ResourceNotFoundException::new);
    }
}
