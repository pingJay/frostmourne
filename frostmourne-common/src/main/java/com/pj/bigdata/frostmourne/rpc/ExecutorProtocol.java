package com.pj.bigdata.frostmourne.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

/**
 *
 * Created by pingjie on 15-11-19.
 */
public interface ExecutorProtocol extends VersionedProtocol {
    public static final Long VERSION = 5426563L;

    public boolean execJob();
}
