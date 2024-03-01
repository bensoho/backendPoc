package com.expd.geodev.backendpoc.job;

import com.expd.geodev.backendpoc.service.QuartzService;
import com.expd.geodev.backendpoc.utils.SpringContextJobUtil;
import org.quartz.*;

import java.time.LocalDateTime;

public class TemplateJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        QuartzService quartzService = (QuartzService) SpringContextJobUtil.getBean("quartzService");


        JobKey key = context.getJobDetail().getKey();
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        System.out.println(key.getName());
        System.out.println(key.getGroup());
        System.out.println(jobDataMap.get("k1"));
        System.out.println(LocalDateTime.now() + "------------------------");
    }
}
