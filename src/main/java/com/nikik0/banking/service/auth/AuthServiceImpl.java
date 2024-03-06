package com.nikik0.banking.service.auth;

import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.service.client.ClientService;
import com.nikik0.banking.web.dto.LoginRequestDto;
import com.nikik0.banking.web.dto.LoginResponseDto;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final TokenService tokenService;
    private final ClientService clientService;
    @Override
    public void register(Client client) {

    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }
}
