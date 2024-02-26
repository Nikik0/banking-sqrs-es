package com.nikik0.banking.event;


import com.nikik0.banking.domain.aggregate.Aggregate;
import com.nikik0.banking.domain.model.Client;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ClientCreatedEvent extends AbstractEvent{

    public ClientCreatedEvent(Client payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {
        //todo
    }
}
