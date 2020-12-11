package com.adus.templateapp.apiimpl;

import com.adus.templateapp.api.RootApi;
import com.adus.templateapp.api.UserApi;
import com.adus.templateapp.users.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UserApi.class)
class UserApiTest {
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @Autowired
    private UserApi userApi;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userApi)
                .build();
    }

    @Test
    void getAllUsers() throws Exception {
        when(userService.getAllUserNames()).thenCallRealMethod();
        MvcResult mvcResult = mockMvc.perform(get(RootApi.API_PREFIX + "/users/")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(
                "{" +
                        "\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/api/v1/users/\"}]," +
                        "\"content\":" +
                        "[" +
                        "{" +
                        "\"username\":\"user_foo\"," +
                        "\"displayName\":null," +
                        "\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/api/v1/users/user_foo\"}]" +
                        "}," +
                        "{" +
                        "\"username\":\"user_bar\"," +
                        "\"displayName\":null," +
                        "\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/api/v1/users/user_bar\"}]" +
                        "}" +
                        "]" +
                        "}",
                mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getUser() throws Exception {
        when(userService.getUser(anyString())).thenCallRealMethod();
        MvcResult mvcResult = mockMvc.perform(get(RootApi.API_PREFIX + "/users/user_foo")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(
                "{" +
                        "\"username\":\"user_foo\"," +
                        "\"displayName\":\"Name of user_foo\"," +
                        "\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost/api/v1/users/user_foo\"}]" +
                        "}",
                mvcResult.getResponse().getContentAsString());
    }

}