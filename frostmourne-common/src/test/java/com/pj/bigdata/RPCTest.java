package com.pj.bigdata;

import com.pj.bigdata.frostmourne.rpc.ExecutorProtocol;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by pingjie on 15-11-25.
 */
public class RPCTest {

    public static void main(String[] args) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",9999);

        ExecutorProtocol executorProtocol = RPC.getProxy(ExecutorProtocol.class, ExecutorProtocol.versionID, inetSocketAddress, new Configuration());
        System.out.println(executorProtocol.execJob(1, 2));
    }
}
