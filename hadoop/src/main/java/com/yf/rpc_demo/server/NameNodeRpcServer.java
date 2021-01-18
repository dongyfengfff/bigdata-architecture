package com.yf.rpc_demo.server;

import com.yf.rpc_demo.ClientProtocol;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;


/**
 * RPC服务端  -- 要实现 协议，即 接口
 * TODO 远程过程调用，即 不同进程间可以调用，通过 client 和 server
 * TODO -- 客户端调用 服务端的代码，代码执行在服务端
 * @author Administrator
 *
 */
public class NameNodeRpcServer implements ClientProtocol {
    /**
     * 创建?录
     */
    @Override
    public void makeDir(String path) {
        System.out.println("服务端："+path);
    }


    public static void main(String[] args) throws Exception {
        Server server = new RPC.Builder(new Configuration())
                .setBindAddress("localhost")
                .setPort(9999)
                .setProtocol(ClientProtocol.class)
                .setInstance(new NameNodeRpcServer())
                .build();

        //启动服务端
        server.start();

    }

}
