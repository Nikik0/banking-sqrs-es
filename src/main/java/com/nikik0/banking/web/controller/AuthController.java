package com.nikik0.banking.web.controller;

import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.service.auth.AuthService;
import com.nikik0.banking.web.dto.*;
import com.nikik0.banking.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private AuthService authService;
    private ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) final ClientDto clientDto) {
        Client client = clientMapper.fromDto(clientDto);
        authService.register(client);
    }

    public LoginResponseDto login(
            @RequestBody @Validated final LoginRequestDto requestDto
    ){
        return authService.login(requestDto);
    }
}
