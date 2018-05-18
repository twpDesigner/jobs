package com.xwtec.jobs.service.impl;

import com.xwtec.jobs.schedule.base.ScheduledJob;
import com.xwtec.jobs.service.ITaskTriggerSchedule;
import com.xwtec.jobs.tuple.JobIdentity;
import com.xwtec.jobs.tuple.JobProperty;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@Transactional
public class TaskTriggerSchedule implements ITaskTriggerSchedule {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    ScheduledJob[] scheduledJobs;

    public void execute(){

        if (scheduledJobs==null||scheduledJobs.length==0)return;

        Arrays.stream(scheduledJobs).forEach(
                iJob -> {
                    JobProperty jobProperty = iJob.getJobProperty();
                    JobIdentity jobDetailConfig = jobProperty.getJobDetail();
                    JobIdentity jobTriggerConfig = jobProperty.getJobTrigger();
                    JobDetail jobDetail = JobBuilder.newJob(jobProperty.getJobClass())
                            .withIdentity(jobDetailConfig.getName(),jobDetailConfig.getGroup()).build();
                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobProperty.getCronTab());

                    CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                            .withIdentity(jobTriggerConfig.getName(),jobTriggerConfig.getGroup())
                            .withSchedule(scheduleBuilder).build();
                    try {
                        scheduler.scheduleJob(jobDetail,cronTrigger);
                    } catch (SchedulerException e) {
                        e.printStackTrace();
                    }
                }
        );



    }
}
