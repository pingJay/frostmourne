package com.pj.bigdata.frostmourne.job;

/**
 * Created by pingjie on 15-11-20.
 */
public class JobType {
    private int id;
    private String type;

    public JobType(String type){
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
