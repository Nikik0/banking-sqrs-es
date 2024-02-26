package com.nikik0.banking.event;

import com.nikik0.banking.domain.aggregate.Aggregate;
import com.nikik0.banking.domain.model.Transaction;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class TransactionCreateEvent extends AbstractEvent{

    public TransactionCreateEvent(Transaction payload) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {
        //todo
    }
}
