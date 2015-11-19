package com.pj.bigdata.frostmourne.execapp.rpc;

import com.pj.bigdata.frostmourne.rpc.ExecutorProtocol;
import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

/**
 * Created by pingjie on 15-11-19.
 */
public class ExecutorProtocolImpl implements ExecutorProtocol {
    public boolean execJob() {
        return false;
    }

    public long getProtocolVersion(String s, long l) throws IOException {
        return ExecutorProtocol.VERSION;
    }

    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return null;
    }
}
