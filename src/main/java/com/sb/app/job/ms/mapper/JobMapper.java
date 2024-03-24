package com.sb.app.job.ms.mapper;

import com.sb.app.job.ms.dto.JobDto;
import com.sb.app.job.ms.entity.Job;
import com.sb.app.job.ms.external.Company;
import com.sb.app.job.ms.external.Review;

import java.util.List;

public class JobMapper {

    public static JobDto mapToJobDto(Job job, Company company, List<Review> reviews) {

        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setTitle(job.getTitle());
        jobDto.setDescription(job.getDescription());
        jobDto.setLocation(job.getLocation());
        jobDto.setMaxSalary(job.getMaxSalary());
        jobDto.setMinSalary(job.getMinSalary());
        jobDto.setCompany(company);
        jobDto.setReviews(reviews);

        return jobDto;

    }
}
