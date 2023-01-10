package com.rszumlas.parceldone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ParcelDoneIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ParcelDoneRepository parcelDoneRepository;

    @Test
    void itShouldSaveParcelDone() throws Exception {
        // Given
        ParcelDoneRequest parcelDoneRequest = new ParcelDoneRequest(1L, 1L, 777, true);

        // When
        // Then
        mockMvc.perform(post("/api/v1/parcel-done", parcelDoneRequest)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Objects.requireNonNull(objectToJson(parcelDoneRequest))))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldCheckIfFinished() throws Exception {
        // Given
        Long parcel_id = 1L;
        given(parcelDoneRepository.checkIfFinished(parcel_id)).willReturn(true);

        // When
        // Then
        mockMvc.perform(get("/api/v1/parcel-done/{parcel_id}", parcel_id))
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
