package com.dnd.gratz.dto.request;

import com.dnd.gratz.db.entity.message.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MessageCretedRequest {
    private String nickName;
    private String giftId;
    private String content;
    private String imageUrl;
    private boolean publicYn;
    private Date openDate;
    private Long eventId;
}
