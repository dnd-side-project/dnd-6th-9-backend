package com.dnd.gratz.service.message;

import com.dnd.gratz.dto.request.MessageCretedRequest;
import com.dnd.gratz.dto.response.MessageResponse;

public interface MessageService {
    void createMessage(MessageCretedRequest messageCretedRequest);
    void deleteMessage(String messageId);
    MessageResponse getMessage(String messageId, String nickName);
}
