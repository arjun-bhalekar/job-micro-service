package com.sb.app.job.ms.dto;

import com.sb.app.job.ms.entity.Job;
import com.sb.app.job.ms.external.Company;

public class JobWithCompanyDto {

    private Job job;
    private Company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
