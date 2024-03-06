package com.nikik0.banking.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardDto {

    @NotNull(
            message = "Id must be not null",
            groups = OnUpdate.class
    )
    @Null(
            message = "Id must be null",
            groups = OnCreate.class
    )
    private UUID id;

    @NotNull(
            message = "Card number must be not null",
            groups = OnCreate.class
    )
    @Null(
            message = "Card number must be null"
    )
    private String number;

    @NotNull(
            message = "Expire date must be not null",
            groups = OnCreate.class
    )
    @Null(
            message = "Expire date must be null"
    )
    private String date;

    @NotNull(
            message = "Cvv must be not null",
            groups = OnCreate.class
    )
    @Null(
            message = "Cvv must be null"
    )
    private String cvv;
}
