package com.nikik0.banking.repository;

import com.nikik0.banking.event.AbstractEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}
