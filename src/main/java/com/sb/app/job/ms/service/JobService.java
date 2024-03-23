package com.sb.app.job.ms.service;

import com.sb.app.job.ms.dto.JobWithCompanyDto;
import com.sb.app.job.ms.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

    Long findJobCountBy(Long companyId);

    List<JobWithCompanyDto> findAllJobWithCompany();

    JobWithCompanyDto findJobWithCompanyByJobId(Long id);
}
