package com.pj.bigdata.frostmourne.execapp.rpc;

import com.pj.bigdata.frostmourne.rpc.ExecutorProtocol;
import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

/**
 * Created by pingjie on 15-11-19.
 */
public class ExecutorProtocolImpl implements ExecutorProtocol {
    public boolean execJob(int i,int y) {
        System.out.println(i+y);
        return true;
    }

    public long getProtocolVersion(String s, long l) throws IOException {
        return versionID;
    }

    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return new ProtocolSignature(versionID,null);
    }
}
