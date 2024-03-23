package com.sb.app.job.ms.repository;

import com.sb.app.job.ms.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

    Long countByCompanyId(Long companyId);

}
