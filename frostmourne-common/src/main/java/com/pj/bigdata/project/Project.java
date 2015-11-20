package com.pj.bigdata.project;

import com.pj.bigdata.frostmourne.job.JobType;

import java.util.Date;

/**
 * Created by pingjie on 15-11-20.
 */
public class Project {
    private int id;
    private Date createtime;
    private Date last_update_time;
    private String name;
    private JobType jobType;
    private String app_path;
    private String class_name;
    private String run_args;
    private String run_cron;
    private BusinessType businessType;
    private String desc;
    private String special_host;
    private int retry_cnt;
    private long retry_interval;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(Date last_update_time) {
        this.last_update_time = last_update_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getApp_path() {
        return app_path;
    }

    public void setApp_path(String app_path) {
        this.app_path = app_path;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getRun_args() {
        return run_args;
    }

    public void setRun_args(String run_args) {
        this.run_args = run_args;
    }

    public String getRun_cron() {
        return run_cron;
    }

    public void setRun_cron(String run_cron) {
        this.run_cron = run_cron;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpecial_host() {
        return special_host;
    }

    public void setSpecial_host(String special_host) {
        this.special_host = special_host;
    }
}
