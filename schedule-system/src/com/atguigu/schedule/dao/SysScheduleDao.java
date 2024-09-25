package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {

    int addSchedule(SysSchedule schedule);

    List<SysSchedule> findAll();
}
