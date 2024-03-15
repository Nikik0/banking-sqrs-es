package com.nikik0.banking.service.auth;

import com.nikik0.banking.domain.exception.ResourceAlreadyExistsException;
import com.nikik0.banking.domain.model.Client;
import com.nikik0.banking.service.client.ClientService;
import com.nikik0.banking.web.dto.LoginRequestDto;
import com.nikik0.banking.web.dto.LoginResponseDto;
import com.nikik0.banking.web.security.jwt.JwtProperties;
import com.nikik0.banking.web.security.jwt.TokenType;
import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final TokenService tokenService;
    private final ClientService clientService;

    private final JwtProperties jwtProperties;

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void register(Client client) {
        if (clientService.existsByUsername(client.getUsername())){
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                )
        );
        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setAccessToken(
                tokenService.create(
                        TokenParameters.builder(
                                loginRequestDto.getUsername(),
                                TokenType.ACCESS.name(),
                                jwtProperties.getAccess()
                        ).build()
                )
        );
        responseDto.setRefreshToken(
                tokenService.create(
                        TokenParameters.builder(
                                loginRequestDto.getUsername(),
                                TokenType.REFRESH.name(),
                                jwtProperties.getRefresh()
                        ).build()
                )
        );
        return responseDto;
    }
}
