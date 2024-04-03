package com.sb.app.job.ms;

import com.sb.app.job.ms.entity.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobApiIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String createURLWithPort() {
        return "http://localhost:" + port + "/jobs";
    }


    @Test
    void testCreateJob() {

        ResponseEntity<String> response = testRestTemplate
                .postForEntity(createURLWithPort(), MockObjectCreator.createMockJob(), String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("Job added successfully", response.getBody());
    }
}
