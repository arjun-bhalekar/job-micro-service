package com.sb.app.job.ms.feignclients;

import com.sb.app.job.ms.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW-MICRO-SERVICE")
public interface ReviewClient {

    @GetMapping("/reviews")
    List<Review> getReviews(@RequestParam Long companyId);
}
