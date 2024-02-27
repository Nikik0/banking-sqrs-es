package com.nikik0.banking.service.client;

import com.nikik0.banking.domain.exception.ResourceNotFoundException;
import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService{

    private final ClientRepository clientRepository;
    @Override
    public Client getById(UUID T) {
        return clientRepository.findById(T).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(String username) {
        return clientRepository.existsByUsername(username);
    }
}
