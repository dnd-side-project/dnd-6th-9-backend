package com.dnd.gratz.dto.request;

import com.dnd.gratz.db.entity.event.Event;
import com.dnd.gratz.db.entity.user.User;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class EventRequestDto {

    private User user;

    @Size(min = 1, max = 45)
    private String eventName;

    @Size(min = 1, max = 200)
    private String eventDescription;

    private Date eventDate;

    @Builder
    public EventRequestDto(User user, @Size(min = 1, max = 45) String eventName, @Size(min = 1, max = 200) String eventDescription, Date eventDate) {
        this.user = user;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    public Event toEntity() {
        return Event.builder()
                .user(user)
                .eventName(eventName)
                .eventDescription(eventDescription)
                .eventDate(eventDate)
                .build();
    }
}
