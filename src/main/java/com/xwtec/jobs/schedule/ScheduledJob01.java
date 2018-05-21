package com.xwtec.jobs.schedule;

import com.xwtec.jobs.service.impl.business.UserService01;
import com.xwtec.jobs.service.impl.business.UserService02;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.task.boot.config.schedule.base.IJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Data@NoArgsConstructor@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ScheduledJob01 implements IJob {

    @Autowired
    UserService01 userService01;

    @Autowired
    UserService02 userService02;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("这是第一个任务 is runningdsadasdsa…………………………………… ");
        List<Map> user01 = userService01.queryAll();
        List<Map> user02 = userService02.queryAll();
        log.info("user01"+user01.toString());
        log.info("user02"+user02.toString());
    }
}
