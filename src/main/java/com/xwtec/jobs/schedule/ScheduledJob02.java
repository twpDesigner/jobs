package com.xwtec.jobs.schedule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.task.boot.config.schedule.base.IJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Data@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ScheduledJob02 implements IJob {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("第二个任务正在运行 is running…………………………………… ");
    }
}
