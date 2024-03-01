package com.expd.geodev.backendpoc.repository;

import com.expd.geodev.backendpoc.model.QuartzEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuartzRepository extends JpaRepository<QuartzEntity, Long> {
    QuartzEntity findByJobName(String jobName);

    @Query(nativeQuery = true, value = "SELECT " +
            "             *  " +
            "            FROM " +
            "            backend_poc.quartz_entity  " +
            "            WHERE " +
            "             ( end_time IS NULL "   +                                // 没有结束时间的
            "              OR ( start_time < NOW() AND end_time > NOW()) " +      // 已经开始但未结束的
            "              OR start_time > NOW() " +                              // 还未开始的
            "             ) " +
            "             AND status = '0'")
    List<QuartzEntity> notStartOrNotEndJobs();
}
