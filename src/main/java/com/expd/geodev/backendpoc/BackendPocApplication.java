package com.expd.geodev.backendpoc;

import com.expd.geodev.backendpoc.model.HelloJob;
import com.expd.geodev.backendpoc.utils.QuartzUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendPocApplication implements ApplicationRunner {

	@Autowired
	private QuartzUtil quartzUtil;

	public static void main(String[] args){
		SpringApplication.run(BackendPocApplication.class, args);
	}

	public static void startJob() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		// define job and bind to HelloJob class
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob", "group1")
				.build();
		// trigger job to run very 40s
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever())
				.build();

		scheduler.scheduleJob(jobDetail, trigger);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		quartzUtil.recoveryAllJob();
	}
}
