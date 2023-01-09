package com.rszumlas.parcel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.vodka.Vodka;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ParcelIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ParcelRepository parcelRepository;

    @Test
    void itShouldInsertParcel() throws Exception {
        // Given
        ParcelRequest parcelRequest = new ParcelRequest("IMPORT", 10, 1L, LocalDateTime.now());

        // When
        // Then
        mockMvc.perform(post("/api/v1/parcel", parcelRequest)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Objects.requireNonNull(objectToJson(parcelRequest))))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldFindParcelById() throws Exception {
        // Given
        Long parcel_id = 1L;
        given(parcelRepository.findById(parcel_id)).willReturn(Optional.of(new Parcel(
                parcel_id,
                "IMPORT",
                new Vodka(1L),
                10,
                LocalDateTime.now()
        )));

        // When
        // Then
        mockMvc.perform(get("/api/v1/parcel/{parcel-id}", parcel_id))
                .andExpect(status().isOk());
    }

    private String objectToJson(Object object) {
        try {
            return new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .setDateFormat(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"))
                    .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            fail("Failed to convert object to json");
            return null;
        }
    }

}