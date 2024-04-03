package com.sb.app.job.ms;


import com.sb.app.job.ms.dto.JobDto;
import com.sb.app.job.ms.entity.Job;

import java.util.ArrayList;
import java.util.List;

public class MockObjectCreator {

    private MockObjectCreator() {
    }

    public static List<JobDto> getMockJobDtoList() {

        List<JobDto> jobDtos = new ArrayList<>();

        JobDto job1 = new JobDto();
        job1.setId(1L);
        job1.setTitle("Mock Job title 1");
        jobDtos.add(job1);

        JobDto job2 = new JobDto();
        job2.setId(2L);
        job2.setTitle("Mock Job title 2");
        jobDtos.add(job2);


        return jobDtos;

    }

    public static Job createMockJob() {
        Job mockJob = new Job();
        mockJob.setId(1L);
        mockJob.setTitle("Mock Job title 1");
        return mockJob;
    }
}
