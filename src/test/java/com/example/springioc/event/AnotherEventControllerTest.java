package com.example.springioc.event;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
// static 변수 자동 완성 안되므로 intelij 커스텀
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// spring에서 test 사용시 ExtendWith 사용
@ExtendWith(SpringExtension.class)
@WebMvcTest
class AnotherEventControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getTest() throws Exception {

        mockMvc.perform(get("/AnotherEvent/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}