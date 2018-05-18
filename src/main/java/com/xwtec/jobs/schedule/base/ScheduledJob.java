package com.xwtec.jobs.schedule.base;

import com.xwtec.jobs.tuple.JobProperty;
import org.quartz.Job;

public abstract class ScheduledJob implements Job {
    private JobProperty jobProperty;

    public ScheduledJob(JobProperty jobProperty) {
        this.jobProperty = jobProperty;
    }

    public ScheduledJob() {
    }

    public JobProperty getJobProperty() {
        return jobProperty;
    }
}
