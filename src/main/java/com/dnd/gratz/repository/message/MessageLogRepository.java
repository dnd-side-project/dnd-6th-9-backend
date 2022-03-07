package com.dnd.gratz.repository.message;

import com.dnd.gratz.db.entity.message.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageLogRepository extends JpaRepository<MessageLog, String> {
    Optional<MessageLog> findByMessageId(String messageId);
}
