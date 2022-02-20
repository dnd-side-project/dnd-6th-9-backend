package com.dnd.gratz.repository.event;

import com.dnd.gratz.db.entity.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
