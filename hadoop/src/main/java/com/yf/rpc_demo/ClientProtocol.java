package com.yf.rpc_demo;

/**
 * 协议  -- 接口
 *
 * Hadoop RPC特点总结
 * 1）不同的进程的调?，客户端调?服务端的?法，?法的执?是在服务端。
 * 2）协议其实说?了指的就是?个接?，这个接???必须有versionID的字段
 * 3）服务端实现了这个协议（接?）??的?法
 * 4) jps 看到的都是 server
 * 5)  如何创建?个服务端：
 *     Server server = new RPC.Builder(new Configuration())
 *          .setBindAddress("localhost")
 *          .setPort(9999)
 *          .setProtocol(ClientProtocol.class)
 *          .setInstance(new NameNodeRpcServer())
 *          .build();
 *
 *  6) Hadoop的RPC的客户端是如何创建可以代理的：
 *      ClientProtocol namenode = RPC.getProxy(ClientProtocol.class,
 *          1234L,
 *          new InetSocketAddress("localhost",9999),
 *          new Configuration());
 *
 */
public interface ClientProtocol {
    long versionID=1234L;
    void makeDir(String path);
}
