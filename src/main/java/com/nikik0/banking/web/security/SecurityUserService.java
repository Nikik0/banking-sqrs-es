package com.nikik0.banking.web.security;

import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {
    private final ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username){
        Client client = clientService.findByUsername(username);
        return new SecurityUser(client);
    }
}
