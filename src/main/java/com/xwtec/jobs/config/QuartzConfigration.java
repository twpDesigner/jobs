package com.xwtec.jobs.config;

import com.xwtec.jobs.service.ITaskTriggerSchedule;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfigration {

//    @ConfigurationProperties(prefix = "spring.quartz")
//    @Bean({"Scheduler"})
//    public Scheduler getScheduler() throws SchedulerException {
//        return StdSchedulerFactory.getDefaultScheduler();
//
//    }

    @Autowired
    ITaskTriggerSchedule iTaskTriggerSchedule;

    @Bean
    public CommandLineRunner commandLineRunner(){
        return new CommandLineRunner(){
            @Override
            public void run(String... args) throws Exception {
                iTaskTriggerSchedule.execute();
            }
        };
    }
}