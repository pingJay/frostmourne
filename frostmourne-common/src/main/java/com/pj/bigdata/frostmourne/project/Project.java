package com.pj.bigdata.frostmourne.project;

import com.pj.bigdata.frostmourne.job.JobType;

import java.util.Date;

/**
 * Created by pingjie on 15-11-20.
 */
public class Project {
    private int id;
    private String userName;
    private Date createtime;
    private Date lastUpdateTime;
    private String projectName;
    private String jobType;
    private String appPath;
    private String className;
    private String runArgs;
    private String runCron;
    private String businessType;
    private String desc;
        private int peiod;
    private String specialHost;
    private String businessTime;
    private int retryCount;
    private int retryInterval;
    private String finalCommand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRunArgs() {
        return runArgs;
    }

    public void setRunArgs(String runArgs) {
        this.runArgs = runArgs;
    }

    public String getRunCron() {
        return runCron;
    }

    public void setRunCron(String runCron) {
        this.runCron = runCron;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPeiod() {
        return peiod;
    }

    public void setPeiod(int peiod) {
        this.peiod = peiod;
    }

    public String getSpecialHost() {
        return specialHost;
    }

    public void setSpecialHost(String specialHost) {
        this.specialHost = specialHost;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public String getFinalCommand() {
        return finalCommand;
    }

    public void setFinalCommand(String finalCommand) {
        this.finalCommand = finalCommand;
    }
}
