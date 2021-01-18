package com.yf.rpc_demo.client;

import com.yf.rpc_demo.ClientProtocol;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * RPC客户端  -- 客户端调用 服务端的代码，代码执行在服务端
 * @author Administrator
 *
 */
public class DFSClient {
    public static void main(String[] args) throws IOException {
        ClientProtocol namenode = RPC.getProxy(ClientProtocol.class,
                1234L,
                new InetSocketAddress("localhost",9999),
                new Configuration());

        namenode.makeDir("/user/opt/soft");
    } }
