package com.nikik0.banking.event;

import com.nikik0.banking.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);
}
