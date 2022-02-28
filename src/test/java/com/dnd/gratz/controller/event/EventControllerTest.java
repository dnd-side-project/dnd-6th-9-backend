package com.dnd.gratz.controller.event;

import com.dnd.gratz.db.entity.user.User;
import com.dnd.gratz.dto.request.EventRequestDto;
import com.dnd.gratz.repository.event.EventRepository;
import com.dnd.gratz.repository.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        eventRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void event_등록된다()throws Exception {
        // given
//        String email = "yunyoung1819@gmail.com";
//        Optional<User> optionalUser = userRepository.findByEmail(email);
//        User user = optionalUser.get();
        User user = User.builder()
                .email("yunyoung1920@gmail.com")
                .nickName("윤영")
                .build();

        String eventName = "bsd";
        String eventDescription = "bsd";
        Date eventDate = new Date();

        EventRequestDto requestDto = EventRequestDto.builder()
                .user(user)
                .eventName(eventName)
                .eventDescription(eventDescription)
                .eventDate(eventDate)
                .build();

        String url = "http://localhost:8080/gratz/event";

        // when
        mvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
    }

}