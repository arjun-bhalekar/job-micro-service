package com.sb.app.job.ms.service.impl;

import com.sb.app.job.ms.entity.Job;
import com.sb.app.job.ms.repository.JobRepository;
import com.sb.app.job.ms.service.Impl.JobServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class JobServiceImplTest {

    @InjectMocks
    private JobServiceImpl jobService;

    @Mock
    private JobRepository jobRepository;

    @Test
    void findAll() {

        Mockito.when(jobRepository.findAll())
                .thenReturn(List.of(new Job[]{new Job(), new Job()}));

        List<Job> jobs =  jobService.findAll();
        Assertions.assertNotNull(jobs);
        Assertions.assertEquals(2, jobs.size());

    }

}
