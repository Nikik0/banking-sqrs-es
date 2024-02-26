package com.nikik0.banking.event;

import com.nikik0.banking.domain.model.utils.ObjectConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "events")
@NoArgsConstructor
public abstract class AbstractEvent implements Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID aggregateId;

    @Enumerated(EnumType.STRING)
    private EventType type;

    @CreationTimestamp
    private LocalDateTime date;

    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = ObjectConverter.class)
    private Object payload;

    public AbstractEvent(UUID aggregateId, EventType type, Object payload) {
        this.aggregateId = aggregateId;
        this.type = type;
        this.payload = payload;
    }
}
