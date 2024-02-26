package com.nikik0.banking.event;

import com.nikik0.banking.domain.aggregate.Aggregate;
import com.nikik0.banking.domain.model.Card;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CardCreatedEvent extends AbstractEvent{

    public CardCreatedEvent(Card payload) {
        super(null, EventType.CARD_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {
       //todo
    }
}
