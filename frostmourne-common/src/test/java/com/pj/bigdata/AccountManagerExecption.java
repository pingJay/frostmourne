package com.pj.bigdata;

/**
 * Created by pingjie on 15-11-24.
 */
public class AccountManagerExecption extends Exception {

    public AccountManagerExecption(String msg){
        super(msg);
    }

    public AccountManagerExecption(String msg,Throwable throwable) {
        super(msg,throwable);
    }
}
