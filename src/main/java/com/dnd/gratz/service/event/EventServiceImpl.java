package com.dnd.gratz.service.event;

import com.dnd.gratz.db.entity.user.User;
import com.dnd.gratz.dto.request.EventRequestDto;
import com.dnd.gratz.repository.event.EventRepository;
import com.dnd.gratz.util.AuthenticationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final AuthenticationUtil authenticationUtil;

    @Override
    @Transactional
    public Long createEvent(EventRequestDto requestDto) {
        User user = authenticationUtil.getUser();
        requestDto.setUser(user);
        return eventRepository.save(requestDto.toEntity()).getId();
    }
}
