package com.adus.apiimpl;

import com.adus.api.RootApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = RootApi.class)
class RootApiTest {
    private MockMvc mockMvc;
    @Autowired
    private RootApi rootApi;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(rootApi)
                .build();
    }

    @Test
    void getModule() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(
                "{" +
                        "\"code\":\"root_api\"," +
                        "\"name\":\"Root Module\"," +
                        "\"subModules\":" +
                        "[" +
                        "{" +
                        "\"code\":\"users_api\"," +
                        "\"name\":\"User Module\"," +
                        "\"subModules\":[]," +
                        "\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/api/v1/users/\"}]" +
                        "}" +
                        "]," +
                        "\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/\"}]}",
                mvcResult.getResponse().getContentAsString());
    }

}