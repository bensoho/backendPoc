package com.expd.geodev.backendpoc.service.impl;

import com.expd.geodev.backendpoc.model.QuartzEntity;
import com.expd.geodev.backendpoc.repository.QuartzRepository;
import com.expd.geodev.backendpoc.service.QuartzService;
import com.expd.geodev.backendpoc.utils.QuartzUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("quartzService")
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    private QuartzRepository quartzRepository;

    @Override
    public void save(QuartzEntity entity) {
        quartzRepository.save(entity);
    }

    @Override
    public boolean modifyJob(QuartzEntity entity) {
        QuartzEntity quartzEntity = quartzRepository.findById(entity.getId()).get();
        if (quartzEntity != null){
            return Objects.nonNull(quartzRepository.save(entity));
        }
        return false;
    }

    @Override
    public boolean modifyTaskStatus(String jobName, String status) {
        QuartzEntity quartzEntity = quartzRepository.findByJobName(jobName);
        if (Objects.nonNull(quartzEntity)){
            quartzEntity.setStatus(status);
            return Objects.nonNull(quartzRepository.save(quartzEntity));
        }
        return false;
    }

    @Override
    public List<QuartzEntity> notStartOrNotEndJobs() {

        return quartzRepository.notStartOrNotEndJobs();
    }
}
