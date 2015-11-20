package com.pj.bigdata.frostmourne.job;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pingjie on 15-11-20.
 */
public class Visitor {

    private int id;
    private String name;
    private int status;
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("{Id: %d, Name: %s, status: %s, CreateTime: %s}", getId(), getName(), getStatus(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreatetime()));
    }
}
