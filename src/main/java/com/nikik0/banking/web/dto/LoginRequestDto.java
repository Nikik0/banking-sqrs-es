package com.nikik0.banking.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    @NotNull(
            message = "Username must not be null"
    )
    private String username;

    @NotNull(
            message = "Password"
    )
    private String password;
}
