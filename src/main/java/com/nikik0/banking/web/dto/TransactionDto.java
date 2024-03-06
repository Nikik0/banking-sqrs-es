package com.nikik0.banking.web.dto;

import com.nikik0.banking.domain.model.Card;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class TransactionDto {

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
            message = "Sender card must be not null",
            groups = OnCreate.class
    )
    @Null(
            message = "Sender must be null"
    )
    @Valid
    private CardDto from;

    @NotNull(
            message = "Receiver card must be not null",
            groups = OnCreate.class
    )
    @Null(
            message = "Receiver must be null"
    )
    @Valid
    private CardDto to;

    @NotNull(
            message = "Amount must be not null"
    )
    @Positive(
            message = "Amount must be positive"
    )
    private BigDecimal amount;
}
