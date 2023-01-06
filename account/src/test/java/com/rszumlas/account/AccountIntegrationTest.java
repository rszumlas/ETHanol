package com.rszumlas.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rszumlas.clients.account.AccountRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountRepository accountRepository;

    @Test
    void itShouldInsertAccount() throws Exception {
        // Given
        AccountRequest accountRequest = new AccountRequest("aaa@gmail.com", "aaa", 0.5);

        // When
        // Then
        mockMvc.perform(post("/api/v1/account", accountRequest)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Objects.requireNonNull(objectToJson(accountRequest))))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldCheckIfEmailAndPasswordExist() throws Exception {
        // Given
        String email = "aaa@gmail.com";
        String password = "aaa";

        // When
        // Then
        mockMvc.perform(get("/api/v1/account/{email}/{password}", email, password))
                .andExpect(status().isOk());
    }

    private String objectToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            fail("Failed to convert object to json");
            return null;
        }
    }

}
