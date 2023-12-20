package com.leadservice.leadservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadservice.leadservice.entity.Lead;
import com.leadservice.leadservice.service.LeadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class LeadServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LeadService leadService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateLead() throws Exception{
        Lead lead = new Lead(105,"John","Doe","Smith","9876543210","Male","01/01/1990","john.smith@example.com");

        ResultActions response = mockMvc.perform(post("/api/v1/lead")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(lead)));

        response.andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.status",
                        is("success")));

    }

}
