package cn.spacewalker.tsp.bg.receiver.launch;

import cn.spacewalker.tsp.bg.receiver.server.Gbt32960Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/11 16:42
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
@SpringBootApplication
@ImportResource("classpath:spring/spring-service.xml")
public class ReceiveLauncher implements CommandLineRunner {

    @Resource
    private Gbt32960Server gbt32960Server;

    public static void main(String[] args) {
        SpringApplication.run(ReceiveLauncher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int port = 0;
        if(args.length > 0){
            String arg = args[0];
            try {
                port = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                //e.printStackTrace();
            }
        }
        gbt32960Server.start(port);
    }
}
