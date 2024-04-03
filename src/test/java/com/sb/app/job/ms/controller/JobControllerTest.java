package com.sb.app.job.ms.controller;

import com.sb.app.job.ms.MockObjectCreator;
import com.sb.app.job.ms.dto.JobDto;
import com.sb.app.job.ms.service.JobService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
class JobControllerTest {

    @InjectMocks
    private JobController jobController;

    @Mock
    private JobService jobService;

    @Test
    void findAll_HappyPath() {

        Mockito.when(jobService.findAllJobWithCompany())
                .thenReturn(MockObjectCreator.getMockJobDtoList());

        ResponseEntity<List<JobDto>> responseEntity = jobController.findAll();
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());

    }

    @Test
    void createJob_HappyPath() {
        ResponseEntity<String> responseEntity = jobController.createJob(MockObjectCreator.createMockJob());
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Job added successfully", responseEntity.getBody());
    }

    @Test
    void getJobById_HappyPath() {

        Mockito.when(jobService.findJobWithCompanyByJobId(1L)).thenReturn(new JobDto());
        ResponseEntity<JobDto> responseEntity = jobController.getJobById(1L);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

    }

    @Test
    void getJobById_NotFound() {
        ResponseEntity<JobDto> responseEntity = jobController.getJobById(1L);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}