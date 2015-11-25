package com.pj.bigdata.frostmourne.execapp;


import com.pj.bigdata.frostmourne.execapp.rpc.ExecutorProtocolImpl;
import com.pj.bigdata.frostmourne.rpc.ExecutorProtocol;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;
import java.io.IOException;

/**
 * Created by pingjie on 15-11-25.
 */
public class ExecutorRPCTest {



    public static void main(String[] args) throws IOException, InterruptedException {
        Configuration conf = new Configuration();

        Server server = new RPC.Builder(conf).setProtocol(ExecutorProtocol.class)
                .setInstance(new ExecutorProtocolImpl()).setBindAddress("127.0.0.1")
                .setNumHandlers(2)
                .setPort(9999).build();
        server.start();
    }
}
