package com.xwtec.jobs.schedule.impl;

import com.xwtec.jobs.schedule.base.ScheduledJob;
import com.xwtec.jobs.tuple.JobIdentity;
import com.xwtec.jobs.tuple.JobProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Data@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ScheduledJob02 extends ScheduledJob {
    private JobProperty jobProperty =
            JobProperty
                    .builder()
                    .jobClass(this.getClass())
                    .cronTab("0/1 * * * * ?")
                    .jobDetail(
                            JobIdentity
                                    .builder()
                                    .group("ScheduledJob02Detailgroup")
                                    .name("ScheduledJob02")
                                    .build()
                    )
                    .jobTrigger(
                            JobIdentity
                                    .builder()
                                    .group("ScheduledJob02Triggergroup")
                                    .name("ScheduledJob02")
                                    .build()
                    )
                    .build();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("第二个任务正在运行 is running…………………………………… ");
    }
}
