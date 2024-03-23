package com.sb.app.job.ms.service.Impl;

import com.sb.app.job.ms.dto.JobWithCompanyDto;
import com.sb.app.job.ms.entity.Job;
import com.sb.app.job.ms.external.Company;
import com.sb.app.job.ms.repository.JobRepository;
import com.sb.app.job.ms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private RestTemplate restTemplate;

    //private List<Job> jobs = new ArrayList<>();
    //private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {

        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public Long findJobCountBy(Long companyId) {
        return jobRepository.countByCompanyId(companyId);
    }

    @Override
    public List<JobWithCompanyDto> findAllJobWithCompany() {

        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertJobToJobWithCompanyDto).collect(Collectors.toList());
    }

    @Override
    public JobWithCompanyDto findJobWithCompanyByJobId(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        if(Objects.nonNull(job))
            return convertJobToJobWithCompanyDto(job);
        else
            return null;
    }

    private JobWithCompanyDto convertJobToJobWithCompanyDto(Job job) {

        JobWithCompanyDto jobWithCompanyDto = new JobWithCompanyDto();
        jobWithCompanyDto.setJob(job);
        //RestTemplate restTemplate = new RestTemplate();
        Company company = restTemplate
                .getForObject("http://COMPANY-MICRO-SERVICE:8081/companies/" + job.getCompanyId(), Company.class);
        jobWithCompanyDto.setCompany(company);
        return jobWithCompanyDto;
    }
}
