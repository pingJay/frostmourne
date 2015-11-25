package com.pj.bigdata.frostmourne.project;

/**
 * Created by pingjie on 15-11-24.
 */
public class ProjectManagerException extends Exception {
    private static final long serialVersionUID = 1L;

    public ProjectManagerException(String msg) {
        super(msg);
    }

    public ProjectManagerException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}
