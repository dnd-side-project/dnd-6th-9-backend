package com.dnd.gratz.controller.message;

import com.dnd.gratz.controller.BaseController;
import com.dnd.gratz.db.entity.message.Message;
import com.dnd.gratz.dto.request.MessageCretedRequest;
import com.dnd.gratz.dto.response.MessageResponse;
import com.dnd.gratz.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MessageController extends BaseController {

    @Autowired
    MessageService messageService;

    /**
     * 메시지 생성
     */
    @PostMapping("/messages")
    public void createMessage(@ModelAttribute MessageCretedRequest messageCretedRequest){
        messageService.createMessage(messageCretedRequest);
    }

    /**
     * 메시지 삭제
     */
    @DeleteMapping("/messages/{message-id}")
    public void deleteMessage(@PathVariable String messageId){
        messageService.deleteMessage(messageId);
    }

    /**
     * 메시지 상세 조회
     * @return Message + readCheck
     */
    @GetMapping("/message/{message-id}/{nick-name}")
    public ResponseEntity<MessageResponse> getMessageDetail(@PathVariable String messageId, @PathVariable String nickName){
        MessageResponse messageResponse = messageService.getMessage(messageId, nickName);
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }
}
