package com.nikik0.banking.service.transaction;

import com.nikik0.banking.domain.exception.ResourceNotFoundException;
import com.nikik0.banking.domain.model.Transaction;
import com.nikik0.banking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService{

    private final TransactionRepository transactionRepository;
    @Override
    public Transaction getById(UUID T) {
        return transactionRepository.findById(T).orElseThrow(ResourceNotFoundException::new);
    }
}
