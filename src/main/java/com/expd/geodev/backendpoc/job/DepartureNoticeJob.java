package com.expd.geodev.backendpoc.job;

import com.expd.geodev.backendpoc.service.OrderService;
import com.expd.geodev.backendpoc.service.QuartzService;
import com.expd.geodev.backendpoc.utils.SpringContextJobUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DepartureNoticeJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        QuartzService quartzService = (QuartzService) SpringContextJobUtil.getBean("quartzService");
        OrderService orderService = (OrderService) SpringContextJobUtil.getBean("orderService");

        String jobName = context.getJobDetail().getKey().getName();
        long orderId = Long.parseLong(jobName);
        // TODO 获取订单及用户信息，封装短信内容，调用短信发送模块发送短信

        quartzService.modifyTaskStatus(jobName, "1");


    }
}
