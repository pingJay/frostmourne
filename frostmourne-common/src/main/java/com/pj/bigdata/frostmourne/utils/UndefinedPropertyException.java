package com.pj.bigdata.frostmourne.utils;

/**
 * Created by pingjie on 15-11-19.
 */
public class UndefinedPropertyException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public UndefinedPropertyException(String msg){
        super(msg) ;
    }
}
