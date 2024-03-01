package com.expd.geodev.backendpoc.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class AwardJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String userId = jobDataMap.getString("userId");
        String awardName = jobDataMap.getString("awardName");
        String awardId = jobDataMap.getString("awardId");
        double awardValue = jobDataMap.getDouble("awardValue");
        log.info("发奖品......");
    }
}
