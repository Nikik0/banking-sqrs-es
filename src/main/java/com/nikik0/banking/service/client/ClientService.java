package com.nikik0.banking.service.client;

import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.service.CommandService;
import com.nikik0.banking.service.QueryService;

public interface ClientService extends CommandService<Client>, QueryService<Client> {
    Client findByUsername(String username);

    boolean existsByUsername(String username);
}
