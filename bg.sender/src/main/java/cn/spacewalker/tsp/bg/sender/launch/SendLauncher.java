package cn.spacewalker.tsp.bg.sender.launch;

import cn.spacewalker.tsp.bg.sender.client.Gbt32960Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/12 11:53
 * Copyright (c) 2017 www.space-walker.cn
 *
 */

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ImportResource("classpath:spring/spring-service.xml")
public class SendLauncher implements CommandLineRunner {

    @Resource
    private Gbt32960Client gbt32960Client;

    public static void main(String[] args) {
        SpringApplication.run(SendLauncher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        gbt32960Client.start();
    }
}
