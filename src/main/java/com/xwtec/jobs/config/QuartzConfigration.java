package com.xwtec.jobs.config;

import lombok.extern.slf4j.Slf4j;
import org.core.task.boot.config.service.ITaskTriggerSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class QuartzConfigration {

    @Autowired
    ITaskTriggerSchedule iTaskTriggerSchedule;

    @Bean
    public CommandLineRunner commandLineRunner(){
        return new CommandLineRunner(){
            @Override
            public void run(String... args) throws Exception {
                iTaskTriggerSchedule.execute();
//                val ss = userService01.queryAll();
//                log.info("ss:"+ss.toString());
            }
        };
    }
}