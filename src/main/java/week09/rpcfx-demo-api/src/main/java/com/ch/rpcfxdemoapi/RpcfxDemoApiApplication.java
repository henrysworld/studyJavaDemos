package com.ch.rpcfxdemoapi;

import com.ch.rpcfxcore.netty.server.RpcNettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RpcfxDemoApiApplication implements ApplicationRunner {

    private final RpcNettyServer rpcNettyServer;

    public RpcfxDemoApiApplication(RpcNettyServer rpcNettyServer) {
        this.rpcNettyServer = rpcNettyServer;
    }


    public static void main(String[] args) {
        SpringApplication.run(RpcfxDemoApiApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            rpcNettyServer.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rpcNettyServer.destroy();
        }
    }
}
