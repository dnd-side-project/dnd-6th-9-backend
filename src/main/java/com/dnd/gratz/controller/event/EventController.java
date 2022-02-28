package com.dnd.gratz.controller.event;

import com.dnd.gratz.dto.request.EventRequestDto;
import com.dnd.gratz.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventService eventService;

    @PostMapping("/event")
    public Long createEvent(@RequestBody EventRequestDto requestDto) {
        return eventService.createEvent(requestDto);
    }
}
