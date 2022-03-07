package com.dnd.gratz.repository.message;

import com.dnd.gratz.db.entity.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, String> {
    Optional<List<Message>> findAllByCreatedDate(Date date);
}
