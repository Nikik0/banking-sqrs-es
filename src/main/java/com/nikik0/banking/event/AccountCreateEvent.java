package com.nikik0.banking.event;

import com.nikik0.banking.domain.aggregate.Aggregate;
import com.nikik0.banking.domain.model.Account;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class AccountCreateEvent extends AbstractEvent{

    public AccountCreateEvent(Account payload){
        super(null, EventType.ACCOUNT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {
        //todo
    }
}
