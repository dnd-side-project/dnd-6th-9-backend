package com.dnd.gratz.service.event;

import com.dnd.gratz.dto.request.EventRequestDto;
import com.dnd.gratz.dto.response.EventResponseDto;

public interface EventService {
    Long createEvent(EventRequestDto requestDto);
}
