package com.dnd.gratz.dto.response;

import com.dnd.gratz.db.entity.message.Message;
import com.dnd.gratz.db.entity.message.MessageLog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageResponse {
    Message message;
    boolean readCheck;
}
