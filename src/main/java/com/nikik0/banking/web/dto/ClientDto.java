package com.nikik0.banking.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
public class ClientDto {

    @Null(
            message = "Id must be null",
            groups = OnCreate.class
    )
    @NotNull(
            message = "Id must be not null",
            groups = OnUpdate.class
    )
    private UUID id;

    @NotNull(
            message = "Id must be not null"
    )
    @Length(
            message = "Name length must be between {min} and {max}",
            max = 256,
            min = 2
    )
    private String name;

    @Email(
            message = "Username must be a valid email"
    )
    @Length(
            message = "Email length must be between {min} and {max}",
            min = 5,
            max = 256
    )
    @NotNull(
            message = "Username can't be null"
    )
    private String username;

    @NotNull(
            message = "Password must not be null"
    )
    @Length(
            message = "Password length must be between {min} and {max}",
            min = 8,
            max = 256
    )
    private String password;
}
