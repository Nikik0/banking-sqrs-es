package com.nikik0.banking.service.client;

import com.nikik0.banking.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientQueryService clientQueryService;

    private final ClientCommandService clientCommandService;
    @Override
    public void create(Client object) {
        clientCommandService.create(object);
    }

    @Override
    public Client getById(UUID T) {
        return clientQueryService.getById(T);
    }

    @Override
    public Client findByUsername(String username) {
        return clientQueryService.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return clientQueryService.existsByUsername(username);
    }
}
