package com.expd.geodev.backendpoc.service;

import com.expd.geodev.backendpoc.model.QuartzEntity;

import java.util.List;

public interface QuartzService {
    void save(QuartzEntity entity);

    boolean modifyJob(QuartzEntity entity);

    boolean modifyTaskStatus(String jobName,String status);

    List<QuartzEntity> notStartOrNotEndJobs();
}
