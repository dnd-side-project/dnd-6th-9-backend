package com.dnd.gratz.service.message;

import com.dnd.gratz.db.entity.common.Gift;
import com.dnd.gratz.db.entity.event.Event;
import com.dnd.gratz.db.entity.message.Message;
import com.dnd.gratz.db.entity.message.MessageLog;
import com.dnd.gratz.db.entity.user.User;
import com.dnd.gratz.dto.request.MessageCretedRequest;
import com.dnd.gratz.dto.response.MessageResponse;
import com.dnd.gratz.repository.event.EventRepository;
import com.dnd.gratz.repository.gift.GiftRepository;
import com.dnd.gratz.repository.message.MessageLogRepository;
import com.dnd.gratz.repository.message.MessageRepository;
import com.dnd.gratz.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    GiftRepository giftRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageLogRepository messageLogRepository;

    @Override
    public void createMessage(MessageCretedRequest messageCretedRequest) {
        Message message = new Message();

        Event event = eventRepository.findById(messageCretedRequest.getEventId()).get();
        Gift gift = giftRepository.findById(messageCretedRequest.getGiftId()).get();
        User user = userRepository.findByNickName(messageCretedRequest.getNickName()).get();

        message.setEvent(event);
        message.setGift(gift);
        message.setUser(user);
        message.setContent(messageCretedRequest.getContent());
        message.setImageUrl(messageCretedRequest.getImageUrl());
        message.setPublicYn(messageCretedRequest.isPublicYn());
        message.setOpenDate(messageCretedRequest.getOpenDate());
        message.setCreatedDate(new Date(System.currentTimeMillis()));
        messageRepository.save(message);
    }

    @Override
    public void deleteMessage(String messageId) {
        messageRepository.deleteById(messageId);
    }

    @Override
    public MessageResponse getMessage(String messageId, String nickName) {
        Message message = messageRepository.getById(messageId);
        boolean readCheck = messageLogRepository.findByMessageId(messageId).isEmpty() ? false : true;

        if(!readCheck && message.getUser().getNickName().equals(nickName)){
            // 메시지 작성자와 열람자가 같은 사람인지 확인
            readCheck = true;
            // log가 없다면 새롭게 추가
            MessageLog messageLog = new MessageLog();
            messageLog.setMessage(message);
            messageLog.setRegDate(new Date(System.currentTimeMillis()));
            messageLogRepository.save(messageLog);
        }

        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage(message);
        messageResponse.setReadCheck(readCheck);
        return messageResponse;
    }
}
