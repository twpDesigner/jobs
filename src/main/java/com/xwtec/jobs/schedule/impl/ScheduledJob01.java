package com.xwtec.jobs.schedule.impl;

import com.xwtec.jobs.mapper.ds01.UserMapper;
import com.xwtec.jobs.schedule.base.ScheduledJob;
import com.xwtec.jobs.service.impl.business.UserService01;
import com.xwtec.jobs.service.impl.business.UserService02;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
@Data@NoArgsConstructor@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ScheduledJob01 extends ScheduledJob {

    private JobProperty jobProperty =
            JobProperty
                    .builder()
                    .jobClass(this.getClass())
                    .cronTab("0/1 * * * * ?")
                    .jobDetail(
                            JobIdentity
                                    .builder()
                                    .group("ScheduledJob01Detailgroup")
                                    .name("ScheduledJob01")
                                    .build()
                    )
                    .jobTrigger(
                            JobIdentity
                                    .builder()
                                    .group("ScheduledJob01Triggergroup")
                                    .name("ScheduledJob01")
                                    .build()
                    )
                    .build();


    @Autowired
    UserService01 userService01;

    @Autowired
    UserService02 userService02;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("这是第一个任务 is running…………………………………… ");
        List<Map> user01 = userService01.queryAll();
        List<Map> user02 = userService02.queryAll();
        log.info("user");
    }
}
