package com.example.demo;


import com.example.demo.validate.User;
import com.example.demo.validate.UserController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = {UserController.class})
public class MvcTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void validateTest() throws Exception {
        User user = new User();
        user.setAge(1);
        user.setName("aa");
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(user);
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/validate/execute")
                                .contentType(MediaType.TEXT_PLAIN)
                                .characterEncoding("UTF-8")
                                .content("1111")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        MockMvcResultMatchers.status().isOk()).andReturn();
    }
}
