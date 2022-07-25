package com.demo.aiven;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import com.demo.aiven.entity.Clouds;
import com.demo.aiven.service.CloudService;
import com.demo.aiven.service.CloudServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * To consider it is being tested only happy path, further scenarios are missing in the implementation
 */
public class CloudServiceTest {
    private MockWebServer mockWebServer;
    private CloudService cloudService;

    @BeforeEach
    void setupMockWebServer() {
        mockWebServer = new MockWebServer();
        cloudService = new CloudServiceImpl(WebClient.builder());
    }

    @Test
    void getCloudsForProvider_shouldReturnList_whenResponseIsOk() {
        mockWebServer.enqueue(
          new MockResponse().setResponseCode(200).setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).setBody(getJson("clouds_data.json"))
        );

        Map<String, List<Clouds>> test = cloudService.getCloudsForProvider(mockWebServer.url("/").url().toString());
        assertThat(test.size()).isEqualTo(1);

    }

    /**
     * E.g when implemented fully this should have been tested
     **/
    @Test
    void getCloudsForProvider_shouldReturnStatusError_whenNoConnection() {
    }

    /**
     * Getting file data for testing
     * @param path
     * @return
     */
    private String getJson(String path) {
        try {
            InputStream jsonStream = this.getClass().getClassLoader().getResourceAsStream(path);
            assert jsonStream != null;
            return new String(jsonStream.readAllBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
