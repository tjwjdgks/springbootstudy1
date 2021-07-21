package com.example.springioc.event;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest({EventConverter.StringToEventConverter.class,EventController.class}) // 계층형 test web과 관련된 bean만 등록 해준다 controller가 주로 등록된다 bean으로 등록 안되면 test 깨질 우려 있음
// {}안에 넣어주면 bean등록 다만 component 스캔이 가능해야함
// 추천 formatter 방법
class EventControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get("/event/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}