package com.sb.app.job.ms.feignclients;

import com.sb.app.job.ms.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-MICRO-SERVICE")
public interface CompanyClient {

    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable Long id);
}
