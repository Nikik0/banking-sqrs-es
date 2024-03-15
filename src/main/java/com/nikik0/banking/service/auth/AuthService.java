package com.nikik0.banking.service.auth;

import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.web.dto.ClientDto;
import com.nikik0.banking.web.dto.LoginRequestDto;
import com.nikik0.banking.web.dto.LoginResponseDto;

public interface AuthService {
    void register(Client client);

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
