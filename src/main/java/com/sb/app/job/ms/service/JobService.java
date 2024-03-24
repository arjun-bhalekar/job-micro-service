package com.sb.app.job.ms.service;

import com.sb.app.job.ms.dto.JobDto;
import com.sb.app.job.ms.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

    Long findJobCountBy(Long companyId);

    List<JobDto> findAllJobWithCompany();

    JobDto findJobWithCompanyByJobId(Long id);
}
