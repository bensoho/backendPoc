package com.expd.geodev.backendpoc.model;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

@Slf4j
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        Trigger trigger = jobExecutionContext.getTrigger();

        log.info(jobDetail.getKey().getGroup());
        log.info(trigger.getKey().getGroup());

    }
}
