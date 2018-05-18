package com.xwtec.jobs.config.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PropertySource("classpath:config/job-rate.yml")
@ConfigurationProperties(prefix = "jobs")
public class RatePropertyConfig {
    /*
    interval:
      - 500
      - 6000
    dateformat:
      - "20:00:00"
      - "08-07 20:00:00"
     */
    private List<String> interval;

    private List<String> dateformat;
}
